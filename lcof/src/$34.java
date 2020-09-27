/**
 * 二叉树中和为某一值的路径
 * 回溯法
 * 先序遍历+路径记录
 * 1.目标值更新
 * 2.路径更新
 * 3.路径记录
 * 4.先序遍历
 * 5.路径恢复
 */

import java.util.LinkedList;
import java.util.List;

public class $34 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }

        helper(root, sum);
        return res;
    }

    public void helper(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        //1.目标值更新
        target -= root.val;
        //2.路径更新
        path.add(root.val);
        //3.路径记录：叶子节点且路径长度满足要求
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }

        //4.先序遍历
        helper(root.left, target);
        helper(root.right, target);
        //5.路径恢复
        path.removeLast();
    }
}
