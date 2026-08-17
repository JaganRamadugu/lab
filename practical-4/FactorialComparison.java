import java.util.Scanner;

public class FactorialComparison {

    // Function for Iterative Factorial
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; ++i) {
            result *= i;
        }
        return result;
    }

    // Function for Recursive Factorial
    // Time Complexity: O(n)
    // Space Complexity: O(n) due to call stack
    public static long factorialRecursive(int n) {
        if (n <= 1) return 1;
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer (e.g., 20): ");

        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input! Please enter an integer.");
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        if (n < 0) {
            System.err.println("Invalid input! Please enter a non-negative integer.");
            scanner.close();
            return;
        }

        // Measure Iterative Implementation
        long startIter = System.nanoTime();
        long resIter = factorialIterative(n);
        long endIter = System.nanoTime();
        long durationIter = endIter - startIter;

        // Measure Recursive Implementation
        long startRec = System.nanoTime();
        long resRec = factorialRecursive(n);
        long endRec = System.nanoTime();
        long durationRec = endRec - startRec;

        // Output Results
        System.out.println("\n--- Results for " + n + "! ---");
        System.out.println("Iterative Result : " + resIter);
        System.out.println("Iterative Time   : " + durationIter + " ns");
        System.out.println("-------------------------------");
        System.out.println("Recursive Result : " + resRec);
        System.out.println("Recursive Time   : " + durationRec + " ns");

        scanner.close();
        System.out.println("R.Jagan "+" 92460118674");
    }
}