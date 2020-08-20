package leetcode.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * @author okr
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new LinkedList();

        preorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    public void preorder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

}
