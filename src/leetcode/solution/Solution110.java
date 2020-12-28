package leetcode.solution;

/**
 * @author okr
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = helper(root.left);
        int hr = helper(root.right);

        if (hl == -1 || hr == -1 || Math.abs(hl - hr) > 1) {
            return -1;
        }else {
            return 1 + Math.max(hl, hr);
        }
    }
}
