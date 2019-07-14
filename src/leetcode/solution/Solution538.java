package leetcode.solution;

public class Solution538 {
    private int acum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        root.val += acum;
        acum = root.val;
        convertBST(root.left);
        return root;
    }
}
