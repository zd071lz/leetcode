package leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList();
        if (root.left != null && root.right != null) {
            q.offer(root.left);
            q.offer(root.right);
        }else if (root.left == null && root.right == null) {
            return true;
        }else{
            return false;
        }
        while (!q.isEmpty()) {
            TreeNode h = q.poll();
            TreeNode t = q.poll();
            if ( h.val != t.val) {
                return false;
            }
            if (h.left != null && t.right != null) {
                q.offer(h.left);
                q.offer(t.right);
            }else if (h.left == null && t.right == null) {
            }else{
                return false;
            }
            if (h.right != null && t.left != null) {
                q.offer(h.right);
                q.offer(t.left);
            }else if (h.right == null && t.left == null) {
            }else{
                return false;
            }
        }
        return true;
    }



}
