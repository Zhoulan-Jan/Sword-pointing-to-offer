/**
 * 删除链表的节点 设链表 h->i->j
 * 给定值i.val，找到被删除节点x的前一个节点prev，指向x的后一个节点
 * 给定删除节点i，
 *      i）链表只有一个节点，即为删除节点，返回null
 *      ii）否则当该节点不是链表尾节点，i = j，删除j
 *      iii）否则（该节点为链表尾节点），遍历删除尾节点
 */
public class $18 {
    public ListNode deleteNode(ListNode head, int val) {
        //链表为空
        if (head == null) {
            return null;
        }

        //链表头节点等于给定值
        if (head.val == val) {
            return head.next;
        }

        ListNode prev = head;
        while (prev.next.val != val) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public ListNode deleteNode2(ListNode head, ListNode toBeDeleted) {
        //链表不存在 或者 被删除节点不存在
        if (head == null || toBeDeleted == null) {
            return null;
        }

        //链表只有一个节点
        if (toBeDeleted == head) {
            return null;
        } else if (toBeDeleted.next != null) { //被删除节点在中间
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        } else {
            //被删除节点在尾部 遍历删除
            ListNode cur = head;
            while (cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
        }

        return head;
    }
}
