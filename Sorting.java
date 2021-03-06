import java.util.Arrays;
public class Sorting {

    public static void main(String[] args) {

        Integer[] arr = {0,2,1,45,1,2,7,5,6,4};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = {0,2,1,45,1,2,7,5,6,4};
        selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));

        System.out.println(binarySearch(arr2, 100, 0,arr2.length-1));
    }

    public static Comparable binarySearch(Comparable[] arr, Comparable find, int f, int b){
        if (f <= b) {
            int mid = (b - f)/2 + f;
            if (arr[mid].compareTo(find) == 0) return mid;
            // go right
            if (arr[mid].compareTo(find) < 0) return binarySearch(arr, find, mid+1, b);
            //go left
            return binarySearch(arr, find, f, mid-1);
        }
        return null;
    }



    public static void bubbleSort(Comparable[] arr){
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++)
                if (arr[i].compareTo(arr[j]) < 0) {
                    swap(arr, i, j);
                    swapped = true;
                }
            if (!swapped) break;
        }
    }

    public static void selectionSort(Comparable[] arr){
        Comparable smallest = null;
        for (int i = 0; i < arr.length; i++) {
            smallest = arr[i];
            int smallestIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (smallest.compareTo(arr[j]) > 0) {
                    smallestIndex = j;
                    smallest = arr[j];
                }
            }
            swap(arr, smallestIndex, i);
        }
    }

    public static void swap(Comparable[] arr, int i, int j){
        Comparable item = arr[i];
        arr[i] = arr[j];
        arr[j] = item;
    }

}
