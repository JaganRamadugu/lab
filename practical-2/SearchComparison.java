import java.util.Scanner;

public class SearchComparison {

    // Linear Search Function
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search Function
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 100000;
        int[] arr = new int[n];

        // Creating a sorted array
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        int key = scanner.nextInt();

        // Linear Search Timing
        long start = System.nanoTime();
        int index = linearSearch(arr, key);
        long stop = System.nanoTime();

        System.out.println("\nLinear Search");
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
        System.out.println("Time Taken : " + ((stop - start) / 1000.0) + " microseconds");

        // Binary Search Timing
        start = System.nanoTime();
        index = binarySearch(arr, key);
        stop = System.nanoTime();

        System.out.println("\nBinary Search");
        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }
        System.out.println("Time Taken : " + ((stop - start) / 1000.0) + " microseconds");
        System.out.println("R.Jagan "+"92460118674");
        scanner.close();
    }
}