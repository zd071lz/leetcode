package leetcode.solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 */
public class Solution144 {
    public static List<Integer> preorderTraversal(final TreeNode root) {

        final List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            final TreeNode pop = stack.pop();
            ans.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return ans;
    }
}
