/**
 * 从上到下打印二叉树 体现具体哪一层
 * 法一：递归
 *      1.当level==results.size()时，创建空链表
 *      2.存放当前节点
 *      3.左子树不为空，递归
 *      4.右子树不为空，递归
 * 法二：队列+链表
 *      1.根节点入队
 *      2.当队列不为空时，
 *          将当前队列的所有节点全放入tmp链表中，并且将节点的左右子树也放入队列中
 *      3.results.add(tmp)
 * 注意：考虑树为空的情况
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class $32ii {
    //递归
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return results;
        }

        helper(root, 0);
        return results;
    }

    public void helper(TreeNode root, int level) {
        List<Integer> tmp = new ArrayList<>();
        if (root == null) {
            return;
        }

        if (level == results.size()) {
            results.add(new ArrayList<>());
        }

        results.get(level).add(root.val);

        if (root.left != null) {
            helper(root.left, level+1);
        }

        if (root.right != null) {
            helper(root.right, level+1);
        }
    }

    //双端队列
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
