
import java.util.Scanner;

public class TSP {
    static int n;
    static int[][] cost;
    static boolean[] visited;
    static int[] path, bestPath;
    static int bestCost = Integer.MAX_VALUE;

    static void tsp(int current, int count, int total) {
        if (count == n) {
            if (cost[current][0] != 0
                    && total + cost[current][0] < bestCost) {
                bestCost = total + cost[current][0];

                for (int i = 0; i < n; i++) {
                    bestPath[i] = path[i];
                }
            }
            return;
        }

        for (int next = 1; next < n; next++) {
            if (!visited[next] && cost[current][next] != 0) {
                visited[next] = true;
                path[count] = next;

                tsp(next, count + 1,
                    total + cost[current][next]);

                visited[next] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities (maximum 10): ");
        n = sc.nextInt();

        if (n < 2 || n > 10) {
            System.out.println("Invalid number of cities.");
            sc.close();
            return;
        }

        cost = new int[n][n];
        visited = new boolean[n];
        path = new int[n];
        bestPath = new int[n];

        System.out.println("Enter cost matrix (0 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        visited[0] = true;
        path[0] = 0;

        tsp(0, 1, 0);

        if (bestCost == Integer.MAX_VALUE) {
            System.out.println("No complete tour exists.");
        } else {
            System.out.println("Minimum cost = " + bestCost);
            System.out.print("Optimal tour: ");

            for (int i = 0; i < n; i++) {
                System.out.print(bestPath[i] + " -> ");
            }

            System.out.println("0");
        }

        sc.close();
    }
}
