package leetcode.solution;

import java.util.LinkedList;
import java.util.List;

public class Solution501 {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        inOrder(root);
        int[] ans  = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    private TreeNode pre;
    private int cur = 1;
    private int max = 0;
    private List<Integer> list = new LinkedList<>();

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null) {
            if (pre.val == root.val) {
                cur++;
            }else{
                cur = 1;
            }
        }
        if (cur == max) {
            list.add(root.val);
        }
        if (cur > max) {
            list.clear();
            list.add(root.val);
            max=cur;
        }
        pre = root;
        inOrder(root.right);
    }
}
