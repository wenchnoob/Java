import java.lang.StringBuilder;
import java.text.MessageFormat;

public class BinaryToDecimal {
    public static void main(String[] args) {
        double before1 = System.nanoTime() / Math.pow(10, 9);
        String binary10 = "1010"; // should be ten
        double after1 = System.nanoTime() / Math.pow(10, 9);

        double before2 = System.nanoTime() / Math.pow(10, 9);
        String binaryBig = "111111010101010101111111";
        double after2 = System.nanoTime() / Math.pow(10, 9);


        String binary5 = "101"; // should be five
        String binary12 = "1100"; // should be 12
        System.out.printf("%d %d %d %d \n", BinaryToDecimal(binary10), BinaryToDecimal(binary5), BinaryToDecimal(binary12), BinaryToDecimal(binaryBig));



        // I do not understand how it takes less time for a longer string :/
        System.out.println(String.format("The time taken for a string of length %d is %f secs", binary10.length(), after1 - before1));
        System.out.println(String.format("The time taken for a string of length %d is %f secs", binaryBig.length(), after2 - before2));


        System.out.println(String.format("The octal to decimal conversion of 0x25 is %d", OctalToDecimal("25"))); // Should be 21
        System.out.println(String.format("The deciaml conversion of 1100 using recursion is %d ", RecursiveBinaryToDecimal(binary12, 0))); // Should be 12
    }

    public static int RecursiveBinaryToDecimal(String binary, int depth){
        if (depth > binary.length() - 1) return 0;
        return Integer.valueOf(String.valueOf(binary.charAt(binary.length() - 1 - depth))) * (int)Math.pow(2, depth) + RecursiveBinaryToDecimal(binary, depth + 1);
    }

    public static int BinaryToDecimal(String binary) {
        binary = new StringBuilder(binary).reverse().toString();
        int sum = 0;
        for(int i = 0; i < binary.length(); i++){
            sum += Integer.valueOf(String.valueOf(binary.charAt(i))) * Math.pow(2, i);
        }
        return sum;
    }

    public static int OctalToDecimal(String binary) {
        binary = new StringBuilder(binary).reverse().toString();
        int sum = 0;
        for(int i = 0; i < binary.length(); i++){
            sum += Integer.valueOf(String.valueOf(binary.charAt(i))) * Math.pow(8, i);
        }
        return sum;
    }
}

