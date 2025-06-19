import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        // Insertion Sort testi
        int[] arr1 = {22, 27, 16, 2, 18, 6};
        insertionSort(arr1.clone());
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Selection Sort testi
        int[] arr2 = {7, 3, 5, 8, 2, 9, 4, 15, 6};
        selectionSort(arr2.clone(), 4);
    }

    // Selection Sort
    public static void selectionSort(int[] arr, int adimSayisi) {
        System.out.println("SELECTION SORT ADIMLARİ:");
        System.out.println("Başlangıç: " + Arrays.toString(arr));

        for (int i = 0; i < Math.min(adimSayisi, arr.length - 1); i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

            System.out.println("Adım " + (i + 1) + ": " + Arrays.toString(arr) +
                    " (Min: " + arr[i] + ")");
        }
    }

    public static void insertionSort(int[] arr) {
        System.out.println("INSERTION SORT ADIMLARİ:");
        System.out.println("Başlangıç: " + Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

            System.out.println("Adım " + i + ": " + Arrays.toString(arr));
        }
    }
}