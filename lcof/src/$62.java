import java.util.Scanner;

/**
 * 圆圈中最后剩下的数字
 * 法一：环形链表模拟圆圈：0 -> 1 -> 2 -> 3 -> 4 ->0
 *      1.cur从0走到2，保存1为pre
 *      2.保存3为next
 *      3.删除2
 *      4.从3开始走
 * 法二：f(n,m) = f(n-1,m)%n
 */
public class $62 {
    //方式正确，但超时
    public int lastRemaining(int n, int m) {
        if (m == 1) {
            return n-1;
        }

        //将数字存入链表中
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }

        ListNode cur = head;
        for (int i = 0; i < n-1; i++) {
            ListNode pre = null;
            for (int j = 1; j < m; j++) {
                //找到被删除节点的前一个节点
                if (j == m-1) {
                    pre = cur;
                }
                //cur向前走
                cur = cur.next;
                //当cur走到链表末尾时，重新指向头节点
                if (cur == null) {
                    cur = head;
                }
            }

            //保存被删除节点的下一个节点
            ListNode next = cur.next;
            if (next == null) {
                next = head;
            }

            //删除节点
            pre.next = next;

            //从下一个节点开始走
            cur = next;
        }

        return cur.val;
    }


    public int lastRemaining2(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
