/**
 * 二叉树的深度
 * 节点为空：0
 * 没有左右子树：1
 * 否则返回左右子树深度的最大值+1
 */
public class $55i {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
