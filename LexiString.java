import java.util.Hashtable;
import java.util.Scanner;
import java.util.Arrays;

public class LexiString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        String lexBook = in.nextLine();
        String[] inputs = new String[testCases];
        for (int i = 0; i < inputs.length; i++) inputs[i] = in.nextLine();

        Hashtable<Character, Integer> newLex = makeLex(lexBook);
        for(int i = 0; i < inputs.length; i++) {
            String s = inputs[i];
            String[] sChars = s.split("");
            quickSort(sChars, newLex, 0, sChars.length-1);
            StringBuilder ans = new StringBuilder();
            for(String c : sChars) ans.append(c);
            System.out.println(ans.toString());
        }
    }

    private static Hashtable<Character, Integer> makeLex(String s) {
        Hashtable<Character, Integer> newLex = new Hashtable<>();
        for(int i = 0; i < s.length(); i++) {
            newLex.put(s.charAt(i), i);
        }
        return newLex;
    }

    private static void quickSort(String[] arr, Hashtable<Character, Integer> lex, int start, int end) {
        if (start < end) {
            int p = partition(arr, lex, start, end);
            quickSort(arr, lex, start, p-1);
            quickSort(arr, lex, p+1, end);
        }
    }

    public static int partition(String[] arr, Hashtable<Character, Integer> lex, int start, int end) {
        Integer pivot = lex.get(arr[end].charAt(0));
        int beforePivot = start - 1;

        for (int i = start; i < end; i++)
            if (lex.get((arr[i].charAt(0))).compareTo(pivot) < 0) swap(arr, ++beforePivot, i);

        swap(arr, ++beforePivot, end);
        return beforePivot;
    }

    public static void swap(Comparable[] arr, int i, int j){
        Comparable item = arr[i];
        arr[i] = arr[j];
        arr[j] = item;
    }
}