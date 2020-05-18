package leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 */
public class Solution1302 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            ans = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                ans += poll.val;
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
            }

        }
        return ans;
    }
}
