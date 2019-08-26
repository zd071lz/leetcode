package leetcode.solution;

public class Solution1022 {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 0);
        return sum;
    }
    private int sum = 0;
    public void helper(TreeNode root, int tmp) {
        if (root.left != null) {
            helper(root.left, tmp * 2 + root.val);
        }
        if (root.right != null) {
            helper(root.right, tmp * 2 + root.val);
        }
        if (root.left == null && root.right == null) {
            sum += tmp * 2 + root.val;
        }
    }
}
