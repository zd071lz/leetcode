package leetcode.solution;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Solution1409 {
    public int[] processQueries(int[] queries, int m) {
        int[] ans = new int[queries.length];
        List<Integer> mList = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            mList.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int idx = mList.indexOf(queries[i]);
            ans[i] = idx;
            mList.remove(idx);
            mList.add(0, queries[i]);
        }
        return ans;
    }
}
