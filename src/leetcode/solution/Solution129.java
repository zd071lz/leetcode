package leetcode.solution;

public class Solution129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 0);
        return ans;
    }
    private int ans;
    public void helper(TreeNode root, int n) {
        if (root.left == null && root.right == null) {
            ans += (n  * 10+ root.val);
        }
        if (root.left != null) {
            helper(root.left, n * 10 + root.val);
        }
        if (root.right != null) {
            helper(root.right, n * 10 + root.val);
        }
    }
}
