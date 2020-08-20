package leetcode.solution;

/**
 * @author okr
 */
public class Solution1008 {
    public TreeNode bstFromPreorder(int[] preorder) {

        this.preorder = preorder;

        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    int idx = 0;
    int[] preorder;
    public TreeNode helper(int lower, int upper) {
        if (idx == preorder.length) {
            return null;
        }

        int val = preorder[idx];
        if (val < lower || val > upper) return null;
        idx++;
        TreeNode root = new TreeNode(val);
        root.left = helper(lower, val);
        root.right = helper(val, upper);
        return root;

    }
}
