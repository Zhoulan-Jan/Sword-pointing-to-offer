/**
 * 字符串的排列
 */

import java.util.*;

public class $38 {
    List<String> list = new ArrayList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    public void dfs(int x) {
        if (x == c.length - 1) {
            list.add(new String(c));
            return;
        }

        for (int i = x; i < c.length; i++) {
            Set<Character> set = new HashSet<>();
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i,  x);
            dfs(x+1);
            swap(i,  x);
        }
    }

    public void swap(int x, int y) {
        char tmp = c[x];
        c[x] = c[y];
        c[y] = tmp;
    }

    //不满足全部用例 只适合给定字符串不存在重复元素的情况
    List<char[]> lists = new ArrayList<>();

    public String[] permutation2(String s) {
        char[] chars = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            chars[0] = s.charAt(i);
            helper(s, chars, 0);
        }

        //得到结果的长度 n*(n-1)....*1
        int len = 1;
        for (int i = 1; i <= s.length(); i++) {
            len *= i;
        }

        //将list转为String[]
        String[] res = new String[len];
        int cnt = 0;
        for (char[] cs : lists) {
            //判断字符数组是否有重复元素 去重
            if (isDuplicate(cs)) {
                res[cnt++] = String.valueOf(cs);
            }

            //System.out.println(Arrays.toString(res));
        }
        return res;
    }

    public void helper(String s, char[] chars, int index) {
        if (index == s.length()-1) {
            lists.add(chars.clone());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            chars[index+1] = s.charAt(i);
            helper(s, chars, index+1);
        }
    }

    //字符数组存在重复元素
    public boolean isDuplicate(char[] s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length; i++) {
            if (set.contains(s[i])) {
                return false;
            } else {
                set.add(s[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        $38 a = new $38();
        String[] results= a.permutation("abc");
        System.out.println(Arrays.toString(results));
    }
}
