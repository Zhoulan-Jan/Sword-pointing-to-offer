import java.util.Arrays;

/**
 * 翻转单词顺序
 * 1.字符串整体翻转
 * 2.每个单词翻转
 *      法一：反转后的字符串根据空格分割得到字符串组
 *           遍历字符串组，对于单词去除空格，去除空单词
 *           翻转单词
 *      法二：start指向单词第一个字符，end往后走，直到走到空格
 *           翻转start到end之间的字符
 *           begin = end
 *           begin，end同时走
 */

public class $58i {
    public static String reverseWords(String s) {
        s = reverse(s);
        String[] groups = s.split(" ");
        //System.out.println("groups: " + Arrays.toString(groups));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < groups.length; i++) {
            String str = groups[i].trim();
            if (str.equals("")) {
                continue;
            }
            res.append(reverse(str));
            if (i < groups.length-1) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static String reverse(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] chars = s.toCharArray();
        while (i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public static String reverseWords2(String s) {
        s = reverseByIdx(s, 0, s.length()-1);

        int start = 0; //指向第一个非空字符
//        while (start < s.length() && s.charAt(start) == ' ') {
//            start++;
//        }
//        System.out.println("第一个start = " + start);

        int end = start;
        StringBuilder res = new StringBuilder();

//        while (end < s.length() && start < s.length()) {
//            while (s.charAt(end) != ' ' && end < s.length()-1) {
//                end++;
//            }
//            System.out.println("end = " + end);
//            String r = reverseByIdx(s, start, end-1);
//            System.out.println("r = " + r);
//            res.append(r + " ");
//
//            start = end;
//            while (s.charAt(start) == ' ' && start < s.length()-1) {
//                start++;
//                end++;
//            }
//        }

        while (end < s.length()) {
            if (s.charAt(start) == ' ') {
                start++;
                end++;
            } else if (end == s.length()-1) {
                String r1 = reverseByIdx(s, start, end);
                res.append(r1);
                break;
            } else if (s.charAt(end) == ' ') {
                String r = reverseByIdx(s, start, --end);
                //System.out.println(" r = " + r);
                res.append(r + " ");
                start = ++end;
            } else {
                end++;
            }
        }
        return res.toString().trim();
    }

    public static String reverseByIdx(String s, int i, int j) {
        int x = i; int y = j;
        char[] chars = s.toCharArray();
        while (i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
        return String.valueOf(chars).substring(x, y+1); //subString的区间是[ , )
    }


    public static void main(String[] args) {
        //System.out.println(reverse("abcd"));

        System.out.println(reverseWords2("a good   example"));
        System.out.println(reverseWords2("  hello world!  "));
        System.out.println(reverseWords2("the sky is blue"));

    }
}
