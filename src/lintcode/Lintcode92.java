package lintcode;

/**
 * 92. 背包问题
 * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 * <p>
 * 样例
 * 样例 1:
 * 输入:  [3,4,8,5], backpack size=10
 * 输出:  9
 * <p>
 * 样例 2:
 * 输入:  [2,3,5,7], backpack size=12
 * 输出:  12
 * <p>
 * 挑战
 * O(n x m) 的时间复杂度 and O(m) 空间复杂度
 * 如果不知道如何优化空间O(n x m) 的空间复杂度也可以通过.
 * <p>
 * 注意事项
 * 你不可以将物品进行切割。
 */
public class Lintcode92 {
    public int backPack(int m, int[] A) {
        int[][] dp = new int[A.length][m + 1];
        for (int j = 0; j < dp[0].length; j++) {
            if (A[0] > j) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = A[0];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (A[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], A[i] + dp[i - 1][j - A[i]]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
