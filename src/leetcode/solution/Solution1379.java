package leetcode.solution;

/**
 * 1379. 找出克隆二叉树中的相同节点
 */
public class Solution1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target) {
            return cloned;
        }
        if (original.left != null) {
            TreeNode t = getTargetCopy(original.left, cloned.left, target);
            if (t != null) {
                return t;
            }
        }
        if (original.right != null) {
            TreeNode t = getTargetCopy(original.right, cloned.right, target);
            if (t != null) {
                return t;
            }
        }
        return null;
    }
}
