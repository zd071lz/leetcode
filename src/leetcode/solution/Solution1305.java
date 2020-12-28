package leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inOrder(root1);
        inOrder(root2);
        ArrayList<Integer> ans = new ArrayList<>(priorityQueue.size());
        while (!priorityQueue.isEmpty()) {
            ans.add(priorityQueue.poll());
        }
        return ans;
    }
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        priorityQueue.offer(root.val);
        if (root.right != null) {
            inOrder(root.right);
        }
    }
}
