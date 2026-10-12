
import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

    static class Edge implements Comparable<Edge> {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int n = sc.nextInt();
        int e = sc.nextInt();

        Edge[] edges = new Edge[e];

        System.out.println("Enter edges (u v weight), vertices 0 to " + (n - 1) + ":");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(u, v, w);
        }

        Arrays.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = 0, total = 0;

        System.out.println("Edges in Minimum Spanning Tree:");

        for (Edge edge : edges) {
            int rootU = find(edge.u);
            int rootV = find(edge.v);

            if (rootU != rootV) {
                System.out.println(edge.u + " - " + edge.v + " : " + edge.weight);

                parent[rootU] = rootV;
                total += edge.weight;
                count++;

                if (count == n - 1) {
                    break;
                }
            }
        }

        if (count != n - 1) {
            System.out.println("Graph is disconnected; MST does not exist.");
        } else {
            System.out.println("Total cost of MST = " + total);
        }

        sc.close();
    }
}
