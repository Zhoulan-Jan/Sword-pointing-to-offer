/**
 * 左旋转字符串
 * 1.分成两部分，各自翻转
 * 2.整体翻转
 */
public class $58ii {
    public static String reverseLeftWords(String s, int n) {
        String x = reverse(s, 0, n-1);

        String y = reverse(s, n, s.length()-1);

        String z = x+y;
        return reverse(z, 0, z.length()-1);
    }

    public static String reverse(String s, int i, int j) {
        int x = i;
        int y = j;
        char[] chars = s.toCharArray();

        while (i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
        return String.valueOf(chars).substring(x, y+1);
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
}
