package leetcode.solution;

/**
 * @author okr
 */
public class Solution124 {
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    private int max = Integer.MIN_VALUE;
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = helper(root.left);
        int hr = helper(root.right);
        max = Math.max(max, root.val + (hl > 0 ? hl : 0) + (hr > 0 ? hr : 0));
        return root.val + Math.max((hl > 0 ? hl : 0) , (hr > 0 ? hr : 0));
    }
}
