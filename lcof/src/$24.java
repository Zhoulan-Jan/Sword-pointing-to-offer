/**
 * 反转链表
 * 测试点：空链表、只有一个节点的链表、多个节点的链表
 */
public class $24 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode newHead = new ListNode(-1);
        while (cur != null) {
            ListNode pnext = cur.next;
            if (cur.next == null) {
                newHead.next = cur;
            }

            cur.next = prev;
            prev = cur;
            cur = pnext;
        }
        return newHead.next;
    }
}
