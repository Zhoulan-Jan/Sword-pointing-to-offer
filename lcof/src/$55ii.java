/**
 * 平衡二叉树
 * 法一：先序遍历每个节点，调用depth得到左右子树深度，判断差值<=1，再递归判断左右子树是否平衡
 *      节点会重复遍历
 * 法二：后序遍历，先判断左右子树是否平衡，再判断该节点是否平衡
 *      每个节点只遍历一次
 */

public class $55ii {
    //后序遍历
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //左子树是否平衡
        int left = helper(root.left);
        if (left == -1) {
            return -1;
        }

        //右子树是否平衡
        int right = helper(root.right);
        if (right == -1) {
            return -1;
        }

        //当该节点左右子树<=1，说明该节点是平衡点，返回深度
        return Math.abs(left - right) <= 1 ? Math.max(left, right)+1 : -1;
    }

    //先序遍历每个节点，调用depth()得到左右子树深度
    public boolean isBalanced2(TreeNode root) {
       if (root == null) {
           return true;
       }

//       if (root.left == null && root.right == null) {
//           return true;
//       }

       if (Math.abs(depth(root.left)-depth(root.right)) > 1) {
           return false;
       }

       return isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(depth(root.left), depth(root.right))+1;
    }
}
