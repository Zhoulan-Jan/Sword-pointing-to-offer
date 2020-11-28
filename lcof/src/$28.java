/**
 * 对称的二叉树
 * 前序遍历 根 左 右
 * 对称的前序遍历 根 右 左
 *    包含 null
 *  两种遍历的结果相同说明是对称的
 */
public class $28 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root, root);
    }

    public boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSymmetricHelper(root1.left, root2.right)
                && isSymmetricHelper(root1.right, root2.left);
    }
}
