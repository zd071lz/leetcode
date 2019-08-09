package leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution671 {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        rval = root.val;
        helper(root);
        return ans;
    }
    private int rval;
    private int ans = -1;
    public void helper(TreeNode root) {
            if (rval != root.val) {
                ans =ans<0?root.val: Math.min(ans, root.val);
            }
        if (root.left != null) {
            helper(root.left);
            helper(root.right);
        }
    }
    public int findSecondMinimumValue3(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        int   curMin = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (root.val != poll.val) {
                    curMin =curMin<0?poll.val: Math.min(curMin, poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            if (root.val != curMin) {
                return curMin;
            }
            curMin = -1;
        }
        return -1;
    }
}
