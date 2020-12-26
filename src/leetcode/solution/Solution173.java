package leetcode.solution;

import java.util.ArrayList;


public class Solution173 {
    public Solution173(TreeNode root) {
        if (root != null) {
            inOrder(root);
        }
        list = new ArrayList();
        index = -1;
    }
    private ArrayList<Integer> list;
    private int index;
    private void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inOrder(root.right);
        }
    }
    public int next() {
        return list.get(++index);
    }

    public boolean hasNext() {
        return index + 1 < list.size();
    }
}
