/**
 * 树的子结构
 * 1.在A中找到跟B根节点相同的节点
 * 2.找到则递归比较A的左右子树与B的左右子树是否相等
 * 3.未找到则在A的左右子树中找与B根节点相同的节点
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class $26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
         boolean res = false;

         if (A != null && B != null) {
             if (A.val == B.val) {
                 res =  isAHaveB(A, B);
             }

             if (!res) {
                 res = isSubStructure(A.left, B);
             }
             if (!res) {
                 res = isSubStructure(A.right, B);
             }
         }
         return res;
    }

    public boolean isAHaveB(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return isAHaveB(A.left, B.left) && isAHaveB(A.right, B.right);
    }
}
