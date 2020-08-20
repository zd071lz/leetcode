package leetcode.solution;

/**
 * 1038. 从二叉搜索树到更大和树
 */
public class Solution1308 {
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.right != null) {
            bstToGst(root.right);
        }
        root.val += sum;
        sum = root.val;
        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }

}
