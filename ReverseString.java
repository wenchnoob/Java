public class ReverseString{

    public static void main(String[] args) {
        String s = "apple";
        System.out.println(s);
        System.out.println(reverse(s));

    }

    public static String reverse(String s) {
        if (s == null || s.length() - 1 == 0) return s;
        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }

}