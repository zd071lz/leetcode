package leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 993. 二叉树的堂兄弟节点
 */
public class Solution993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode equalXPNode = null, equalYPNode = null;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    if (poll.left.val == x) {
                        equalXPNode = poll;
                    } else if (poll.left.val == y) {
                        equalYPNode = poll;
                    } else {
                        queue.offer(poll.left);
                    }
                }
                if (poll.right != null) {
                    if (poll.right.val == x) {
                        equalXPNode = poll;
                    } else if (poll.right.val == y) {
                        equalYPNode = poll;
                    } else {
                        queue.offer(poll.right);
                    }
                }
            }
            if (equalXPNode != null && equalYPNode != null &&equalXPNode!=equalYPNode) {
                return true;
            }else  if (equalXPNode != null || equalYPNode != null){
                return false;
            }
        }
        return false;
    }
}
