/**
 * 第一个只出现一次的字符
 */
public class $50 {
    public char firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-97]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)-97] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
