package leetcode.solution;

import java.util.Arrays;

/**
 * 1051. 高度检查器
 */
public class Solution1051 {
    public int heightChecker(int[] heights) {
        int[] sorts = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sorts);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorts[i]) {
                res++;
            }
        }
        return res;
    }
}
