import java.util.Scanner;
import java.util.Arrays;
import java.util.Hashtable;

public class CollisionCourse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        double[] times = new double[testCases];
        for(int i = 0; i < testCases; i++) times[i] = Math.sqrt(Math.pow(in.nextInt(), 2) + Math.pow(in.nextInt(), 2))/in.nextInt();

        Hashtable<Double, Integer> sameTime = new Hashtable<>();

        for(double time : times) {
            if (!sameTime.containsKey(time)) sameTime.put(time, 1);
            else sameTime.put(time, sameTime.get(time) + 1);
        }

        int count = 0;
        for(double key: sameTime.keySet()) count += count(sameTime.get(key));

        System.out.println(count);
    }

    public static int count(int value) {
        if(value == 1) return 0;
        return (value-1) + count(value -1);
    }
}