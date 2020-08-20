package leetcode.solution;

import java.util.*;

/**
 * @author okr
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }
        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        while (true) {
            for (int i = l; i <= r; ++i) {
                ans.add(matrix[u][i]);
            }
            if (++u > d) {
                break;
            }
            for (int i = u; i <= d; ++i) {
                ans.add(matrix[i][r]);
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >=l; --i) {
                ans.add(matrix[d][i]);
            }
            if (--d < u) {
                break;
            }
            for (int i = d; i >=u; --i) {
                ans.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }

        return ans;
    }
}
