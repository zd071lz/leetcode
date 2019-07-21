package leetcode.solution;

public class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        if (root != null) {
            helper(root);
        }
        return ans;
    }
    private int pre = -1;
    private int ans = Integer.MAX_VALUE;
    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            getMinimumDifference(root.left);
        }
        if (pre != -1) {
            ans = Math.min(ans,Math.abs(pre - root.val));
            pre = root.val;
        } else {
            pre = root.val;
        }
        if (root.right != null) {
            getMinimumDifference(root.right);
        }
    }
}
