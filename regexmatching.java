import java.util.Scanner;

class regexmatching {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a";

        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        return check(s, p, 0, 0, '\0');
    }

    public static boolean check(String s, String p, int i, int j, char last) {
        if (i >= s.length())
            return true;
        if (j >= p.length())
            return false;

        char ch = s.charAt(i);

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            if (p.charAt(j) == '.' || p.charAt(j) == ch) {
                return check(s, p, i, j + 2, '\0') || check(s, p, i + 1, j, ch);
            } else {
                return check(s, p, i, j + 2, '\0');
            }
        } else if (ch == p.charAt(j) || p.charAt(j) == '.') {
            return check(s, p, i + 1, j + 1, ch);
        } else {
            return false;
        }
    }
}
