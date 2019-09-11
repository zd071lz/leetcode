package leetcode.solution;

public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean flag = false;
        if (s != null && t != null) {
            if (s.val == t.val) {
                flag = doesMatch(s, t);
            }
            if (!flag ) {
                flag = isSubtree(s.left, t);
            }
            if (!flag ) {
                flag = isSubtree(s.right, t);
            }
        }
        return flag;
    }
    public boolean doesMatch(final TreeNode s, final TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null&& t == null) {
            return false;
        }
        if (s == null &&t != null) {
            return false;
        }
        if (s.val !=  t.val) {
            return false;
        }
        return this.doesMatch(s.left, t.left) && this.doesMatch(s.right, t.right);
    }
}
