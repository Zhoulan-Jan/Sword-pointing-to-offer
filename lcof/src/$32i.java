/**
 * 从上到下打印二叉树
 * 利用队列
 * 要求返回数组，未知数组长度，只能先用list，再转为数组
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class $32i {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.peek();
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
            res.add(tmp.val);
            queue.poll();
        }

        //将list转为数组
        int[] result = new int[res.size()];
        int cnt = 0;
        for (int x : res) {
            result[cnt++] = x;
        }
        return result;
    }
}
