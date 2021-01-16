package leetcode.dp.distinct;

public class Leetcode1155 {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        int mod = 1000000007;
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = i; j <= target; j++) {
                for(int k = 1; k <= f && j - k >= 0; k ++){
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                }
            }
        }
        return dp[d][target];
    }

    public static void main(String[] args) {
        int mod = 10^9+7;
        System.out.println(mod);
    }
}
