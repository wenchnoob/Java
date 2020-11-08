import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        Integer[] arr = {12, 117, 52, 34, 56, 87, 3, 12, 14, 25};
        mergesort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    // Took some time, but I finally successfully implemented it myself :)
    public static void mergesort(Comparable[] arr, int start, int end){
        if (end - start > 1) {
            int mid = (end - start)/2 + start;
            mergesort(arr, start, mid);
            mergesort(arr, mid, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(Comparable[] arr, int start, int mid, int end) {
        Comparable[] arrCopyL = Arrays.copyOfRange(arr, start, mid);
        Comparable[] arrCopyR = Arrays.copyOfRange(arr, mid, end);

        int lpointer = 0;
        int rpointer = 0;

        for(int i = start; i < end; i++) {
            if (lpointer < arrCopyL.length && rpointer < arrCopyR.length) {
                if (arrCopyL[lpointer].compareTo(arrCopyR[rpointer]) < 0) {
                    arr[i] = arrCopyL[lpointer++];
                } else {
                    arr[i] = arrCopyR[rpointer++];
                }
            } else if (lpointer < arrCopyL.length) {
                arr[i] = arrCopyL[lpointer++];
            } else {
                arr[i] = arrCopyR[rpointer++];
            }
        }
    }
}