/**
 * 调整数组顺序，使得奇数在前，偶数在后
 * 双指针，i指向头，j指向尾，当i指向奇数一直向后移动，遇到偶数停止
 *         当j指向偶数一直向前移动，遇到奇数停止
 *         交换i，j指向的值
 *         循环。
 * 使得函数具有 扩展性
 */
public class $21 {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 != 0) {
                i++;
            }
            while (i < j && nums[j] % 2 != 1) {
                j--;
            }
            swap(nums, i, j);
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //具有扩展性的函数
    public int[] exchange2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && fun(i)) {
                i++;
            }
            while (i < j && !fun(j)) {
                j--;
            }
            swap(nums, i, j);
        }
        return nums;
    }

    public boolean fun(int i) {
        if (i % 2 != 0) {
            return true;
        }
        return false;
    }

}
