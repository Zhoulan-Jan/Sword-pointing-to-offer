/**
 * 旋转数组的最小数字
 * 首先看旋转数组 [ 3,4,5,1,2 ]的特点：为两个有序的递增数组a、b，a 的第一个数字一般大于 b 的最后一个数字，b 的第一个数字即为最小值
 * 特例：[1,3,5] 一个递增数组。当 a 的第一个数字小于b 的最后一个数字即为一个递增数组，只需返回 a 的第一个数字
 *     [1,1,1,0,1] 当无法判断 nums[mid] 是属于哪个数组时，使用顺序查找
 *
 * 步骤：1.i 指向第一个数字，j 指向最后一个数字
 *      2.得到中间数字 nums[mid]，若三个数相等时，则进行顺序查找
 *      若其 <= j 指向的元素，则 j = mid；若其 >= i 指向的元素，则 i = mid；
 *      3.当 i 指向 a 的最后一个数字，j 指向 b 的最后一个数字，循环结束，返回 nums[j]
 */

public class $11 {
    public static int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        if (numbers[i] < numbers[j]) {
            return numbers[i];
        }
        while (i < j && j - i != 1) { //j-i == 1退出循环
            int mid = (i+j) / 2;
            if (numbers[mid] == numbers[i] && numbers[i] == numbers[j]) {
                //三个数相等，只能顺序查找 放在第一个
                return findOrder(i, j, numbers);
            } else if (numbers[mid] <= numbers[j]) { // <=
                j = mid;
            } else if (numbers[mid] >= numbers[i]) {
                i = mid;
            }
        }
        return numbers[j];
    }

    public static int findOrder(int left, int right, int[] nums) {
        int min = nums[left];
        for (int i = left; i < right; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }

    //大神解法
    public int minArray2(int[] nums) {
         int left = 0, right = nums.length - 1;
         while (left < right) {
             int mid = (left + right) / 2;
             if (nums[mid] > nums[right]) left = mid + 1;
             else if (nums[mid] < nums[right]) right = mid;
             else right = right - 1;
         }
         return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int[] nums2 = {2,2,2,0,1};
        int[] nums3 = {1,1,1,0,1};
        int[] nums4 = {1,3,5}; //递增数列
        System.out.println(minArray(nums) + " 1");
        System.out.println(minArray(nums2) + " 0");
        System.out.println(minArray(nums3) + " 0");
        System.out.println(minArray(nums4) + " 1");
    }
}
