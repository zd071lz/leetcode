package leetcode.bst;

import leetcode.solution.TreeNode;

/**
 * @author okr
 */
public class Leetcode938 {
    private int total;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return total;
    }

    public void inorder(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        inorder(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            total += root.val;
        }
        inorder(root.right, low, high);
    }
}
