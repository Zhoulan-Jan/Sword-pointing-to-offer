import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class $59i {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];

        for (int i = 1-k, j = 0; j < nums.length; i++, j++) {
            //滑动窗口滑过该数字
            if (i > 0 && deque.peekFirst() == nums[i-1]) {
                deque.removeFirst();
            }

            //若新加入的数字 > 队列已有数字，则删除队列中 < 新加入的数字
            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
                deque.removeLast();
            }

            //将新数字加入到队列中
            deque.addLast(nums[j]);

            //记录滑动窗口最大值，即队列首元素
            if (i >= 0) {
                res[i] = deque.peekFirst();
            }

        }
        return res;
    }
}
