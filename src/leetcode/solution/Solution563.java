package leetcode.solution;

public class Solution563 {
    public int findTilt(TreeNode root) {
        helper(root);
        return ans;
    }
    private int ans;
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ls = helper(root.left);
        int rs = helper(root.right);
        ans+=Math.abs(ls - rs);
        return root.val + ls + rs;
    }
}
