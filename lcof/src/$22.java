/**
 * 链表中倒数第k个节点
 * 快慢指针
 * 注意代码的鲁棒性！！
 * 1.链表为空
 * 2.k <= 0
 * 3.k > 链表总节点数
 */
public class $22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    //链表倒数第k个结点 //长度-k
    public ListNode FindKthToTail(ListNode head, int k){
        int offset = size(head) - k;
        for (int i = 0; i < offset; i++) {
            head = head.next;
        }
        return head;
    }

}
