package leetcode.solution;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lb, Integer rb) {
        if (root == null) {
            return true;
        }
        if (lb != null && root.val <= lb) {
            return false;
        }
        if (rb != null && root.val >= rb) {
            return false;
        }
        return helper(root.left, lb, root.val) && helper(root.right, root.val, rb);
    }
}
