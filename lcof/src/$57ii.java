import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和为s的连续正数序列
 * 1.初始值：small=1;big=2
 * 2.small+……+big > s,增大small
 *                < s,增大big
 *                = s,保存该数列
 * 3.一直增加到small < (1+target)/2为止
 */

public class $57ii {
    public static int[][] findContinuousSequence(int target) {
//        int[][] res = new int[12][];
//        int cnt = 0;
        List<int[]> res = new ArrayList<>();
        int small = 1;
        int big = 2;
        while (small < (1+target)/2) {
            int ans = 0;
            for (int i = small; i <= big; i++) {
                ans += i;
            }
            if (ans > target) {
                small++;
            } else if (ans < target) {
                big++;
            } else {
                int[] tmp = new int[big-small+1];
                for (int i = small; i <= big; i++) {
                    tmp[i-small] = i;
                }
                res.add(tmp);
                small++;
                big++;
            }
        }
        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] res = findContinuousSequence(15);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
