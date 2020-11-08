import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        Integer[] arr = {12, 17, 34, 53, 56, 32, 12, 32, 43, 23};
        quicksort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quicksort(Comparable[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quicksort(arr, start, p-1);
            quicksort(arr, p+1, end);
        }
    }
    public static int partition(Comparable[] arr, int start, int end) {
        Comparable pivot = arr[end];
        int beforePivot = start - 1;
        for (int i = start; i < end; i++)
            if (arr[i].compareTo(pivot) < 0) swap(arr, ++beforePivot, i);
        swap(arr, ++beforePivot, end);
        return beforePivot;
    }
    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
