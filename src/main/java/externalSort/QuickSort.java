package externalSort;

/** Quicksort implementation discussed in class, where the middle element is picked as the pivot.
 *  This is needed for external sort. */
public class QuickSort {
    public static void quickSort(int arr[], int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int arr[], int low, int high) {
        int pivot;
        int tmp;
        int max = high;
        int mid = (low + high) / 2;

        tmp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = tmp;
        pivot = arr[high];
        low--;
        do {
            while (arr[++low] < pivot)
                ;
            while ((low < high) && (arr[--high] > pivot))
                ;
            tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
        } while (low < high);
        tmp = arr[low];
        arr[low] = arr[max];
        arr[max] = tmp;
        return low;
    }

    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

}
