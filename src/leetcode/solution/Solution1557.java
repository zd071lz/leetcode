package leetcode.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * 1557. 可以到达所有点的最少点数目
 */
public class Solution1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] tmp = new boolean[n];
        for (List<Integer> edge : edges) {
            tmp[edge.get(1)] = true;
        }
        List<Integer> ret = new LinkedList<>();
        for (int i = 0; i < tmp.length; i++) {
            if (!tmp[i]) {
                ret.add(i);
            }
        }
        return ret;
    }
}
