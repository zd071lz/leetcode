package leetcode.solution;

public class Solution404 {

    public int sumOfLeftLeaves(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.helper(root);
        return this.ans;
    }

    private int ans = 0;

    public void helper(final TreeNode root) {
        if (root.left != null) {
            this.helper(root.left);
            if (root.left.left == null && root.left.right == null) {
                this.ans += root.left.val;
            }
        }
        if (root.right != null) {
            this.helper(root.right);
        }
    }
}
