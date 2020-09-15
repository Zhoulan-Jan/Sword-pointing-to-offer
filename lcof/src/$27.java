
/**
 * 二叉树的镜像
 * 1.遇到空节点和叶子节点，则返回本身
 * 2.遇到非叶子节点，则交换左右子树
 * 3.当左右子树不为空时，递归左右子树
 */
public class $27 {
    public TreeNode mirrorTree(TreeNode root) {
        //叶子节点和空节点
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        //非叶子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if (root.left != null) {
            mirrorTree(root.left);
        }

        if (root.right != null) {
            mirrorTree(root.right);
        }
        return root;
    }
}
