
import java.util.Scanner;

public class Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        boolean[] visited = new boolean[n];
        int total = 0;

        System.out.println("Enter adjacency matrix (0 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();

                if (i != j && cost[i][j] == 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        visited[0] = true;
        System.out.println("Edges in Minimum Spanning Tree:");

        for (int edges = 0; edges < n - 1; edges++) {
            int min = Integer.MAX_VALUE;
            int u = -1, v = -1;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && cost[i][j] < min) {
                            min = cost[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }

            if (u == -1) {
                System.out.println("Graph is disconnected.");
                return;
            }

            System.out.println(u + " - " + v + " : " + min);
            total += min;
            visited[v] = true;
        }

        System.out.println("Total cost of MST = " + total);
        sc.close();
    }
}
