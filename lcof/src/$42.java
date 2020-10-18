/**
 * 连续子数组的最大和
 * 法一：遍历
 * 法二：当当前和 <= 0，当前和 = 目前值
 *      否则，当前和 += 目前值
 *      目前值可能为负值，要记录当前和的最大值
 * 法三：动态规划，同二
 *
 * 考虑鲁棒性：数组为空，数组长度<=0，指定返回0
 * 如何与子数组最大和0区分 --> 设用全局变量
 *
 */
public class $42 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int resSum = 0x80000000; //最小值
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum <= 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            if (resSum < curSum) {
                resSum = curSum;
            }
        }
        return resSum;
    }
}
