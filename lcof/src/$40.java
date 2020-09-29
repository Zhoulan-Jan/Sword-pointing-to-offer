/**
 * 最小的K个数
 * 法一：利用快排，当随机选择的数最终的下标 == k-1，返回
 *
 * 法二：堆和红黑树
 *      求前k小的元素，用大根堆
 *      1.当堆中元素不满k个，加入
 *      2.当……满，且堆中最大的元素 > 新元素，弹出堆顶元素，加入新元素
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class $40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k <= 0) {
            return new int[0];
        }
        if (arr.length < k) {
            return arr;
        }
        int start = 0;
        int end = arr.length-1;
        int index = partition(arr, start, end);

        while (index != k-1) {
            if (index > k-1) {
                end = index-1;
                index = partition(arr, start, end);
            } else {
                start = index+1;
                index = partition(arr, start, end);
            }
        }
        
        return Arrays.copyOf(arr, k);
    }

    //自己实现的快排 不对
    public int partition2(int[] arr, int start, int end) {
        int pivot = arr[start];
        while (start < end) {
            while (start < end && arr[end] > pivot) {
                end--;
            }
            while (start < end && arr[start] < pivot) {
                start++;
            }
            swap(arr, start, end);
        }
        arr[start] = arr[end];
        arr[start] = pivot;
        return start;
    }

    //前后遍历法 能解决数字相同的情况
    private int partition1(int[] arr, int left, int right) {
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


    private int partition(int[] nums, int low, int high) {
        int v = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (++i <= high && nums[i] < v) {

            }
            while (--j >= low && nums[j] > v) {

            }
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[low] = nums[j];
        nums[j] = v;
        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //法二
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        //默认小根堆，大根堆需要重写比较器
        Queue<Integer> queue = new PriorityQueue<>((v1,v2)->v2-v1);

        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        //将优先队列中的元素转为数组
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,2,0,5};
        $40 a = new $40();
        System.out.println(Arrays.toString(a.getLeastNumbers(nums, 2)));
    }
}
