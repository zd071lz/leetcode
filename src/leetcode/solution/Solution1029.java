package leetcode.solution;

import java.util.Arrays;

public class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        int[] d = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            d[i] = costs[i][0] - costs[i][1];
        }
        Arrays.sort(d);
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            ans += costs[i][1];
        }
        for (int i = 0; i < costs.length/2; i++) {
            ans += d[i];
        }
        return ans;
    }
}
