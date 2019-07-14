package leetcode.solution;

public class Solution814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
