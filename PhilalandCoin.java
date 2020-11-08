import java.util.Scanner;
public class PhilalandCoin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int i = 0; i < testCases; i++) System.out.println(countCoins(in.nextInt()));
    }


    // Built in lib functions #This work, but for some reason my code would fail for certain case
    private static int countCoins(int coin) {
        return (int)Math.floor((Math.log(coin) / Math.log(2))) + 1;
    }


    // Iterative solution #failed: test case unknown
    private static int countCoins(int coin) {
        int count = 0;
        do {
            coin = coin - coin/2;
            count++;
        } while(coin != 1);
        return count;
    }


    // Recursive solution #failed: test case unknown
    private static int countCoins(int coin, int count) {
        coin -= coin/2;
        if (coin == 1) return count;
        return countCoins(coin, ++count);
    }
}