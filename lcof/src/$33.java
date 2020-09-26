/**
 * 二叉搜索树的后序遍历序列
 *
 */
public class $33 {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length-1);
    }

    public boolean helper(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int v = postorder[end];

        int i = start;
        for (; i < end; i++) {
            if (postorder[i] > v) {
                break;
            }
        }

        int j = i;
        for (; j < end; j++) {
            if (postorder[j] < v) {
                return false;
            }
        }

        return helper(postorder, start, i-1) &&  helper(postorder, i, end-1);
    }

    //递归简化版
    public boolean verifyPostorder2(int[] postorder) {
        return helper2(postorder, 0, postorder.length-1);
    }

    public boolean helper2(int[] postorder, int start, int end) {
        while (start >= end) {
            return true;
        }

        int p = start;
        while (postorder[p] < postorder[end]) {
            p++;
        }

        int m = p;

        while (postorder[p] > postorder[end]) {
            p++;
        }

        return p == end && helper2(postorder, start, m-1) && helper2(postorder, m, end-1);

    }

    public static void main(String[] args) {
        $33 a = new $33();
        int[] nums = {1,6,3,2,5};
        int[] nums2 = {1,3,2,6,5};
        System.out.println(a.verifyPostorder(nums));
        System.out.println(a.verifyPostorder(nums2));
    }
}
