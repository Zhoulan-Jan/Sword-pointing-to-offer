/**
 * 在排序数组中查找数字i
 * 法一：1.二分查找找到一个指定值
 *      2.左右顺序找到全部的值
 * 法二：1.二分查找直接找到一个K和最后一个K
 *      nums[mid] < t , 后半段找
 *      nums[mid] > t , 前半段找
 *      nums[mid] == t , nums[mid-1] != t ? 找到 : 继续在前半段找
 *                       nums[mid+1] != t ? 找到 : 继续在后半段找
 *                       注意考虑边界，不要越界，考虑没找到的情况
 */
public class $53i {
    //法二
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        int start = -1;
        int end = -1;

        //二分查找找到第一个K
        while (left <= right) {
            mid = (left+right)/2;

            if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                if ((mid > 0 && nums[mid-1] != target) || mid == 0) {
                    break;
                } else {
                    right = mid-1;
                }
            }
        }
        start = left <= right ? mid : -1;

        left = 0;
        right = nums.length-1;

        //二分查找找到最后一个K
        while (left <= right) {
            mid = (left+right)/2;

            if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                if ((mid < nums.length-1 && nums[mid+1] != target) || mid == nums.length-1) {
                    break;
                } else {
                    left = mid+1;
                }
            }
        }
        end = left <= right ? mid : -1;

        //当第一个K和最后一个K都存在的情况下，返回差值，否则就是没找到
        if (start != -1 && end != -1) {
            return end-start+1;
        } else {
            return 0;
        }
    }

    public int search2(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while (left <= right) { //是小于等于
            mid = (left + right) / 2;

            if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                break;
            }
        }

        int cnt = 0;
        for (int i = mid; i >= 0 && nums[i] == target; i--) {
            cnt++;
        }
        for (int i = mid+1; i < nums.length && nums[i] == target; i++) {
            cnt++;
        }
        return cnt;
    }


}
