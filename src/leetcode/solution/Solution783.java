package leetcode.solution;

public class Solution783 {
    public int minDiffInBST(final TreeNode root) {
        this.helper(root);
        return this.ans;
    }

    private TreeNode pre;
    private int ans = Integer.MAX_VALUE;

    public void helper(final TreeNode root) {
        if (root == null) {
            return;
        }
        this.helper(root.left);
        if (this.pre != null) {
            this.ans = Math.min(Math.abs(this.pre.val - root.val), this.ans);
        }
        this.pre = root;
        this.helper(root.right);
    }
}
