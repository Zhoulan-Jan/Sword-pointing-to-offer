/**
 * 合并两个排序链表
 * 法一：新建链表
 * 法二：递归
 */
public class $25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newTail.next = new ListNode(l1.val);
                newTail = newTail.next;
                l1 = l1.next;
            } else {
                newTail.next = new ListNode(l2.val);
                newTail = newTail.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            newTail.next = new ListNode(l1.val);
            newTail = newTail.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            newTail.next = new ListNode(l2.val);
            newTail = newTail.next;
            l2 = l2.next;
        }

        return newHead.next;
    }

    //递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode newHead;

        if (l1.val <= l2.val) {
            newHead = l1;
            newHead.next = mergeTwoLists2(l1.next, l2);
        } else {
            newHead = l2;
            newHead.next = mergeTwoLists2(l1, l2.next);
        }

        return newHead;
    }
}
