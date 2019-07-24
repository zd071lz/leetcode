package leetcode.solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution653 {
    public boolean findTarget(final TreeNode root, final int k) {
        if (root == null) {
            return false;
        }
        final List<Integer> list = new LinkedList<>();
        Solution653.helper(root, list);
        final Set<Integer> set = new HashSet<>();
        for (final Integer i : list) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(k - i);
            }
        }
        return false;
    }

    public static void helper(final TreeNode root, final List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
