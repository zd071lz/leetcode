package leetcode.solution;

public class Solution437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + helper(root.left, sum) + helper(root.right, sum);
    }
}
