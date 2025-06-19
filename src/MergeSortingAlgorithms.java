

public class MergeSortingAlgorithms {
    public static void main(String[] args) {
        // Test array - the one given in the project
        int[] arr = {16, 21, 11, 8, 12, 22};

        System.out.println("=== MERGE SORT ALGORITHM ===");
        System.out.println("Original array:");
        printArray(arr);

        System.out.println("\n--- SORTING PROCESS ---");
        // Call merge sort - this will recursively divide and merge
        mergeSort(arr, 0, arr.length - 1, 0);

        System.out.println("\n--- FINAL RESULT ---");
        System.out.println("Sorted array:");
        printArray(arr);

        // Big-O Analysis
        System.out.println("\n=== BIG-O ANALYSIS ===");
        System.out.println("Time Complexity:");
        System.out.println("  Best Case:    O(n log n)");
        System.out.println("  Average Case: O(n log n)");
        System.out.println("  Worst Case:   O(n log n)");
        System.out.println("Space Complexity: O(n) - for temporary arrays");

        System.out.println("\nWhy O(n log n)?");
        System.out.println("  - We divide the array log n times (depth of recursion)");
        System.out.println("  - At each level, we process n elements");
        System.out.println("  - Total: n × log n operations");
    }

    /**
     * Main merge sort method - recursively divides the array
     *
     * @param arr   - array to be sorted
     * @param left  - starting index of the subarray
     * @param right - ending index of the subarray
     * @param depth - current recursion depth (for visualization)
     */
    public static void mergeSort(int[] arr, int left, int right, int depth) {
        // Base case: if subarray has only one element or is empty, it's already sorted
        if (left < right) {
            // Print current division step
            printDivisionStep(arr, left, right, depth);

            // Find the middle point to divide the array into two halves
            int middle = left + (right - left) / 2;
            // Note: We use (right - left) / 2 to avoid integer overflow

            // Recursively sort the left half
            System.out.println("  " + "  ".repeat(depth) + "Sorting left half...");
            mergeSort(arr, left, middle, depth + 1);

            // Recursively sort the right half
            System.out.println("  " + "  ".repeat(depth) + "Sorting right half...");
            mergeSort(arr, middle + 1, right, depth + 1);

            // Merge the two sorted halves
            System.out.println("  " + "  ".repeat(depth) + "Merging...");
            merge(arr, left, middle, right, depth);
        }
    }

    /**
     * Merges two sorted subarrays into one sorted subarray
     *
     * @param arr    - main array
     * @param left   - start of left subarray
     * @param middle - end of left subarray / start-1 of right subarray
     * @param right  - end of right subarray
     * @param depth  - current depth for visualization
     */
    public static void merge(int[] arr, int left, int middle, int right, int depth) {
        // Calculate sizes of the two subarrays to be merged
        int leftSize = middle - left + 1;  // Size of left subarray
        int rightSize = right - middle;    // Size of right subarray

        // Create temporary arrays to hold the subarrays
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // Copy data from main array to temporary arrays
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }

        // Print what we're merging
        System.out.print("  " + "  ".repeat(depth) + "Merging ");
        printSubArray(leftArray);
        System.out.print(" and ");
        printSubArray(rightArray);
        System.out.println();

        // Merge the temporary arrays back into the main array
        int i = 0;      // Index for left subarray
        int j = 0;      // Index for right subarray
        int k = left;   // Index for main array

        // Compare elements from both subarrays and merge them in sorted order
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                // Left element is smaller or equal, take it
                arr[k] = leftArray[i];
                i++;
            } else {
                // Right element is smaller, take it
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from left array (if any)
        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from right array (if any)
        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

        // Show the result of this merge
        System.out.print("  " + "  ".repeat(depth) + "Result: ");
        printSubArrayFromMain(arr, left, right);
        System.out.println();
    }

    /**
     * Utility method to print the entire array
     */
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Utility method to print a subarray (temporary array)
     */
    public static void printSubArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    /**
     * Utility method to print a portion of the main array
     */
    public static void printSubArrayFromMain(int[] array, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(array[i]);
            if (i < end) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    /**
     * Shows the division step for visualization
     */
    public static void printDivisionStep(int[] arr, int left, int right, int depth) {
        System.out.print("  ".repeat(depth) + "Dividing: ");
        printSubArrayFromMain(arr, left, right);
        if (left < right) {
            int middle = left + (right - left) / 2;
            System.out.print(" → ");
            printSubArrayFromMain(arr, left, middle);
            System.out.print(" | ");
            printSubArrayFromMain(arr, middle + 1, right);
        }
        System.out.println();

    }

}
