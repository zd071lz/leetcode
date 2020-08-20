package leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author okr
 */
public class Solution1261 {
    public Solution1261(TreeNode root) {
        set = new HashSet<>();
        root.val = 0;
        set.add(root.val);
        helper(root);
    }

    Set<Integer> set;
    public void helper(TreeNode root) {
        if (root.left != null) {
            root.left.val =2 * root.val + 1;
            set.add(root.left.val);
            helper(root.left);
        }
        if (root.right != null) {
            root.right.val =2 * root.val + 2;
            set.add(root.right.val);
            helper(root.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
