import java.util.Stack;

/**
 * 两个链表的第一个公共节点
 * 法一：1.得到AB链表的长度，计算出差值
 *      2.较长的链表先走x步
 *      3.两个链表同时走并比较，第一个相同节点就是公共节点
 *
 * 法二：1.将两个链表的节点依次放入栈中
 *      2.比较两个节点是否相同，若相同，则弹出
 *      3.找到最后一个相同的节点
 */
public class $52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //得到AB链表的长度，计算出差值
        int lenA = len(headA);
        int lenB = len(headB);
        int x = lenA > lenB ? lenA - lenB : lenB - lenA;

        //较长的链表先走x步
        if (lenA > lenB) {
            for (int i = 0; i < x; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < x; i++) {
                headB = headB.next;
            }
        }

        //两个链表同时走并比较，第一个相同节点就是公共节点
        for (int i = 0; ;i++) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
    }

    public int len(ListNode head) {
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        return len;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Stack<ListNode> stackA = new Stack();
        Stack<ListNode> stackB = new Stack();

        //将两个链表的节点依次放入栈中
        for (ListNode cur = headA; cur != null; cur = cur.next) {
            stackA.push(cur);
        }
        for (ListNode cur = headB; cur != null; cur = cur.next) {
            stackB.push(cur);
        }

        //若栈顶元素不相同，说明两链表不相交
        if (stackA.peek() != stackB.peek()) {
            return null;
        }

        //比较两个节点是否相同，若相同，则弹出
        ListNode res = null;
        while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek() == stackB.peek()) {
            //找到最后一个相同的节点
            res = stackA.peek();
            stackA.pop();
            stackB.pop();
        }

        return res;
    }
}
