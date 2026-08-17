import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeapSortComparison {

    // Utility swap function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Reverse array in-place
    private static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    //------------------ MAX HEAP ------------------//
    public static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, n, largest);
        }
    }

    public static void maxHeapSort(int[] arr) {
        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--)
            maxHeapify(arr, n, i);

        // Heap Sort
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, i, 0);
        }
    }

    //------------------ MIN HEAP ------------------//
    public static void minHeapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] < arr[smallest])
            smallest = left;

        if (right < n && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i) {
            swap(arr, i, smallest);
            minHeapify(arr, n, smallest);
        }
    }

    public static void minHeapSort(int[] arr) {
        int n = arr.length;

        // Build Min Heap
        for (int i = n / 2 - 1; i >= 0; i--)
            minHeapify(arr, n, i);

        // Heap Sort
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            minHeapify(arr, i, 0);
        }

        // Reverse to get ascending order
        reverse(arr);
    }

    //------------------ MAIN ------------------//
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] original = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            original[i] = rand.nextInt(100000);
        }

        int[] maxHeapArray = Arrays.copyOf(original, original.length);
        int[] minHeapArray = Arrays.copyOf(original, original.length);

        //---------------- MAX HEAP SORT ----------------//
        long startMax = System.nanoTime();
        maxHeapSort(maxHeapArray);
        long endMax = System.nanoTime();

        //---------------- MIN HEAP SORT ----------------//
        long startMin = System.nanoTime();
        minHeapSort(minHeapArray);
        long endMin = System.nanoTime();

        //---------------- DISPLAY TIME ----------------//
        long nanoMax = endMax - startMax;
        long microMax = nanoMax / 1000;

        long nanoMin = endMin - startMin;
        long microMin = nanoMin / 1000;

        System.out.println("\n========== MAX HEAP SORT ==========");
        System.out.println("Nanoseconds  : " + nanoMax + " ns");
        System.out.println("Microseconds : " + microMax + " us");

        System.out.println("\n========== MIN HEAP SORT ==========");
        System.out.println("Nanoseconds  : " + nanoMin + " ns");
        System.out.println("Microseconds : " + microMin + " us");

        scanner.close();
        System.out.println("R.Jagan "+" 92460118674");
    }
}