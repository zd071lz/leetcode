package leetcode.solution;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution894 {
    Map<Integer, List<TreeNode>> dp = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if (!dp.containsKey(N)) {
            List<TreeNode> ans  = new LinkedList<>();
            if (N == 1) {
                TreeNode treeNode = new TreeNode(0);
                ans.add(treeNode);
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; x++) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x)) {
                        for (TreeNode right : allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                    }
                }
            }
            dp.put(N, ans);
        }
        return dp.get(N);
    }
}
