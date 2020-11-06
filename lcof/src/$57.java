/**
 * 和为s的两个数字
 * 递增数组，双指针
 */
public class $57 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int[] res = new int[2];

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                res[0] = nums[i];
                res[1] = nums[j];
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
