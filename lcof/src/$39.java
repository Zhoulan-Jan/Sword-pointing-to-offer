/**
 * 数组中出现次数超过一半的数字
 * 法一：数组排序，返回len/2下标的数字
 * 法二：基于Partition
 *       1.选定基准值，Partition后，得到该基准值的下标index
 *       2.若index == len/2，则成功
 *         index > len/2，则修改end，在左边Partition
 *         index < len/2，则修改start，在右边Partition
 * 法三：数组特点，该数字出现次数总和 > 其他数字出现总和
 *       1.遍历数组，保存两个值：数字res，次数cnt
 *       2.当cnt==0时，保存下一个数字，且cnt设为1
 *       3.或者当数字res与下一个数字不同时，cnt++
 *         当……相同时，cnt--
 * ps：数组为空
 *     选中的数字出现的次数 != len/2
 */

import java.util.Arrays;

public class $39 {
    //法一
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //法二 运行失败  应该是时间超出限制
    public int majorityElement2(int[] nums) {
        int mid = nums.length/2;
        int start = 0;
        int end = nums.length-1;
        int index = partition(nums, start, end);

        while (index != mid) {
            if (index > mid) {
                end = index-1;
                index = partition(nums, start, end);
            } else {
                start = index+1;
                index = partition(nums, start, end);
            }
        }

        return nums[mid];
    }


    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    //自己写的快排不对
    public int partition2(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] > pivot) {
                end--;
            }
            while (start < end && nums[start] < pivot) {
                start++;
            }
            swap(nums, start, end);
        }
        nums[start] = pivot;
        return start;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //法三
    public int majorityElement3(int[] nums) {
        int res = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                res = nums[i];
                cnt = 1;
            } else if (res == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        $39 a = new $39();
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(a.majorityElement2(nums));

        int[] nums2 = {5,6,2};
        //System.out.println(a.partition(nums2, 0, 2));
    }
}
