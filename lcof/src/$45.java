/**
 * 把数组排成最小的数
 * 自定义排序规则：m、n
 *              若 mn < nm，定义 m小于 n
 *              若 mn > nm，定义 m大于 n
 *              若 mn = nm，定义 m等于 n
 * 拼接字符串可能会导致溢出，将数字转化为字符串
 */

import java.util.Arrays;

public class $45 {
    public String minNumber(int[] nums) {
        //将数字数组转化为字符串数组
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        //自定义排序规则进行排序
        Arrays.sort(strNums, (x, y)->(x+y).compareTo(y+x));

        //字符串数组拼接
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strNums.length; i++) {
            res.append(strNums[i]);
        }

        return res.toString();
    }
}
