import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Utility swap function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Merge Sort
    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    // Quick Sort
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        final int n = 100;
        int[] arr = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }

        System.out.println("Number of Elements = " + n + "\n");

        // Bubble Sort Timing
        long start = System.nanoTime();
        int[] temp = Arrays.copyOf(arr, arr.length);
        bubbleSort(temp);
        long stop = System.nanoTime();
        System.out.printf("Bubble Sort Time    : %.2f microseconds%n", (stop - start) / 1000.0);

        // Selection Sort Timing
        start = System.nanoTime();
        temp = Arrays.copyOf(arr, arr.length);
        selectionSort(temp);
        stop = System.nanoTime();
        System.out.printf("Selection Sort Time : %.2f microseconds%n", (stop - start) / 1000.0);

        // Insertion Sort Timing
        start = System.nanoTime();
        temp = Arrays.copyOf(arr, arr.length);
        insertionSort(temp);
        stop = System.nanoTime();
        System.out.printf("Insertion Sort Time : %.2f microseconds%n", (stop - start) / 1000.0);

        // Merge Sort Timing
        start = System.nanoTime();
        temp = Arrays.copyOf(arr, arr.length);
        mergeSort(temp, 0, n - 1);
        stop = System.nanoTime();
        System.out.printf("Merge Sort Time     : %.2f microseconds%n", (stop - start) / 1000.0);

        // Quick Sort Timing
        start = System.nanoTime();
        temp = Arrays.copyOf(arr, arr.length);
        quickSort(temp, 0, n - 1);
        stop = System.nanoTime();
        System.out.printf("Quick Sort Time     : %.2f microseconds%n", (stop - start) / 1000.0);
        System.out.println("R. Jagan" +" 92460118674");
    }
}