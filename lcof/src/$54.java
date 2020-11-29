/**
 * 二叉搜索树的第k大节点
 * 中序遍历得到递增序列
 * 中序遍历倒序得到递减序列，第k大节点即为递减序列的第k个数字
 */
public class $54 {
    //中序递归遍历倒序
    //递归遍历时计数，遍历到k时返回结果，提前终止
    int res;
    int k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);

        k--;
        if (k == 0) {
            res = root.val;
            return;
        }

        dfs(root.left);
    }




    //得到中序遍历序列，返回倒数第k个数字
    static StringBuffer ans = new StringBuffer();
    public static int kthLargest2(TreeNode root, int k) {
        helper(root);
        String[] vals = ans.toString().split(",");

        return Integer.parseInt(vals[vals.length-k]);
    }

    public static void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        ans.append(root.val).append(",");
        helper(root.right);
    }

    //二叉搜索树的第k个节点
    public static TreeNode kthNode(TreeNode root, int k) {
        if (root == null || k == 0) {
            return null;
        }

        return kthNodeHelper(root, k);
    }

    public static TreeNode kthNodeHelper(TreeNode root, int k) {
        TreeNode target = null;

        if (root.left != null) {
            target = kthNodeHelper(root.left, k);
        }

        if (target == null) {
            if (k == 1) {
                target = root;
            }
            k--;
        }

        if (target == null && root.right != null) {
            target = kthNodeHelper(root.right, k);
        }

        return target;
    }

    public static void main(String[] args) {

        String data = "3,1,4,null,2,null,null,null,null,null,null,null,null,null,null"; //
        TreeNode root = $37.deserialize(data);
        //System.out.println(kthNode(root, 4).val);
        helper(root);
        System.out.println(ans.toString());

        $54 a = new $54();
        System.out.println(a.kthLargest(root, 1));
    }
}
