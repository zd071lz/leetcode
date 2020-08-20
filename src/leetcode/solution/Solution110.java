package leetcode.solution;

/**
 * @author okr
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return x > 1;
    }
    private int x = 0;
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = helper(root.left);
        int hr = helper(root.right);

        x = Math.max(x, Math.abs(hl - hr));
        return 1 + Math.max(hl, hr);
    }
}
