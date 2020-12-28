package leetcode.solution;

public class Solution687 {

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    int ans = 0;
    public int arrowLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = arrowLength(root.left);
        int right = arrowLength(root.right);
        int arrowLeft = 0;
        int arrowRight = 0;
        if (root.left != null&&root.val==root.left.val) {
            arrowLeft = left + 1;
        }
        if (root.right != null&&root.val==root.right.val) {
            arrowRight = right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

}
