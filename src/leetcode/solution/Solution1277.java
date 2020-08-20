package leetcode.solution;

/**
 * @author okr
 */
public class Solution1277 {
    public static int countSquares(int[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                ans++;
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 1) {
                dp[0][j] = 1;
                ans++;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1;
                    ans++;
                    int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    if (min > 0) {
                        dp[i][j] += min;
                        ans += min;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        countSquares(new int[][]{{1,0,1},{1,1,0},{1,1,0}});
    }
}
