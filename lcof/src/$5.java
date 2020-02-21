/**
 * 统计空格数量，得到新字符数组的长度
 * 从后往前拷贝（字符不用重复移动），遇到空格则替换为 %20
 * 将字符数字转为字符串
 */

public class $5 {
    public static String replaceSpace(String s) {
        if (s.length() == 0) {
            return s;
        }
        //统计空格数量
        int blank = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                blank++;
            }
        }
        //不存在空格
        if (blank == 0) {
            return s;
        }
        //存在空格，进行变换
        char[] newS = new char[s.length() + blank * 2 ];
        int newIdx = s.length() + blank * 2 - 1; //新字符串的下标
        int oldIdx = s.length() - 1; //旧字符串的下标
        while (newIdx >= 0 && oldIdx >= 0) {
            if (s.charAt(oldIdx) == ' ') {
                newS[newIdx--] = '0';
                newS[newIdx--] = '2';
                newS[newIdx--] = '%';
            } else {
                newS[newIdx--] = s.charAt(oldIdx);
            }
            oldIdx--;
        }
        return String.valueOf(newS);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("How are you"));
    }
}
