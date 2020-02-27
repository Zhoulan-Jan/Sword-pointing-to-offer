import java.util.Arrays;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class $6 {
    //栈
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new int[]{head.val};
        }
        Stack<Integer> stack = new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
    //递归
    //原地改变结点指向
    public static int[] reversePrint3(ListNode head) {
        ListNode cur = head;
        ListNode pNext = cur.next;
        ListNode newHead;

        int cnt = 0;
        while (true) {
            ListNode tmp = pNext;
            pNext.next = cur;
            cur = tmp;
            pNext = cur.next;
            cnt++;
            if (cur.next == null) {
                newHead = cur;
                break;
            }
        }
        int[] res = new int[cnt];
        int i = 0;
        while (newHead.next != null) {
            res[i++] = newHead.val;
            newHead = newHead.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode three = new ListNode(2);
        ListNode two = new ListNode(3);
        head.next = three;
        three.next = two;

        System.out.println(Arrays.toString(reversePrint(head)));
    }
}
