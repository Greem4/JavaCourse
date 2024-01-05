package edu.javacourse.bit;

public class StarterTwo {
    private static final int UPPER = 1;
    private static final int SPACE = 2;
    private static final int REVERSE = 4;
    public static void main(String[] args) {
        String s = "qwerty asdfgh zxcvbn";
        String t = stringTransform(s, UPPER);
        System.out.println(t);
    }
    private static String stringTransform(String s, int flags) {
        if ((flags & UPPER) != 0) {
            s = s.toUpperCase();
        }
        if ((flags & SPACE) != 0) {
            s = s.replaceAll("\\s+", "");
        }
        if ((flags & REVERSE) != 0) {
            s = new StringBuilder(s).reverse().toString();
        }
        return s;
    }
}
