package leetcode.solution;

/**
 * @author okr
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null &&  hasPathSum(root.left, sum - root.val)) {
            return true;
        }
        if (root.right != null && hasPathSum(root.right, sum - root.val)) {
            return true;
        }
        return false;
    }
}
