package leetcode.solution;

/**
 *
 */
public class Solution1315 {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, false);
        return ans;
    }
    private int ans = 0;
    public void dfs(TreeNode root, boolean isParentEven) {
        if (root.left != null) {
            ans += isParentEven ? root.left.val : 0;
            dfs(root.left, root.val % 2 == 0);
        }
        if (root.right != null) {
            ans += isParentEven ? root.right.val : 0;
            dfs(root.right, root.val % 2 == 0);
        }
    }
}
