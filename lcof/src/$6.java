import java.util.ArrayList;
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
            return new int[]{};
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
    public static ArrayList<Integer> tmp = new ArrayList<>();
    public static int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        if (head.next == null) {
            return new int[]{head.val};
        }
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    public static void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        tmp.add(head.val);
    }

    //逆置单链表 原地改变结点指向
    public static int[] reversePrint3(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        ListNode newHead = null;

        int cnt = 0;
        while (cur != null) {
            ListNode tmp = cur.next;
            if (tmp == null) {
                newHead = cur; //后面不能加 break，不然 cur 的指向就没有了
            }
            cur.next = pre;
            pre = cur;
            cur = tmp;
            cnt++;
        }
        int[] res = new int[cnt];
        int i = 0;
        while (newHead != null) {
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

        System.out.println(Arrays.toString(reversePrint3(head)));
    }
}
