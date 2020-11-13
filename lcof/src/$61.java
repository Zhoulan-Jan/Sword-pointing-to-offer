import java.util.Arrays;

/**
 * 扑克牌中的顺子
 * 1.数组排序
 * 2.统计数组中0的个数 x
 * 3.统计排序后数组中相邻数字的空缺数 y
 * 4.当x >= y 连续，否则不连续
 * ps：当数组中出现数字相同的时候，视为不连续
 */
public class $61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        while (nums[i] == 0) {
            i++;
        }

        int cntZero = i;
        int cntGap = 0;

        for (;i < nums.length-1; i++) {
            if (nums[i+1] == nums[i]) {
                return false;
            }

            if (nums[i+1] != nums[i]+1) {
                cntGap += nums[i+1]-nums[i]-1;
            }
        }

        if (cntZero >= cntGap) {
            return true;
        }
        return false;
    }
}
