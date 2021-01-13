package leetcode.dp.target;

public class Leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int[] count = countzeroesones(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (count[0] > j || count[1] > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }else{
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - count[0]][k - count[1]] + 1);
                    }
                }
            }

        }
        return dp[strs.length][m][n];
    }
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }
}
