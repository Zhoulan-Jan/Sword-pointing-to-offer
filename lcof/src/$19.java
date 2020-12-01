public class $19 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return helper(s, p,0,0);
    }

    public boolean helper(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }

        if (i != s.length() && j == p.length()) {
            return false;
        }

        if (i == s.length() && j != p.length()) {
            return false;
        }

        if (j < p.length()-1 && p.charAt(j+1) == '*') {
            if ((i != s.length() && p.charAt(j) == '.') || (i != s.length() && s.charAt(i) == p.charAt(j))) {
                return helper(s, p, i+1, j+2)
                        ||helper(s, p, i+1, j)
                        || helper(s, p, i, j+2);
            } else {
                return helper(s, p, i, j + 2);
            }
        }

        System.out.println("i = " + i + " j = " + j);

        if ((i != s.length() && p.charAt(j) == '.') || (i != s.length() && s.charAt(i) == p.charAt(j))) {
            return helper(s, p, i + 1, j + 1);
        }

        return false;
    }

    public static void main(String[] args) {
        $19 a = new $19();
//        System.out.println(a.isMatch("aa", "a") + " f");
//        System.out.println(a.isMatch("aa", "a*") + " t");
//        System.out.println(a.isMatch("aab", "c*a*b") + " t");
//        System.out.println(a.isMatch("mississippi", "mis*is*p*.") + " f");
        System.out.println(a.isMatch("ab", ".*c") + " f");

    }
}
