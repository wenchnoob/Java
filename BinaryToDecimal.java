import java.lang.StringBuilder;

public class BinaryToDecimal {
    public static void main(String[] args) {
        String binary10 = "1010"; // should be ten
        String binary5 = "101"; // should be five
        String binary12 = "1100"; // should be 12
        System.out.printf("%d %d %d", BinaryToDecimal(binary10), BinaryToDecimal(binary5), BinaryToDecimal(binary12));
    }

    public static int BinaryToDecimal(String binary) {
        binary = new StringBuilder(binary).reverse().toString();
        int sum = 0;
        for(int i = 0; i < binary.length(); i++){
            sum += Integer.valueOf(String.valueOf(binary.charAt(i))) * Math.pow(2, i);
        }
        return sum;
    }
}

