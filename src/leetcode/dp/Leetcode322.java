package leetcode.dp;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        //TODO 未通过 https://vincentxwd.github.io/blog/2018/08/11/%E6%80%BB%E7%BB%93-%E5%85%B3%E4%BA%8E01%E8%83%8C%E5%8C%85%E5%92%8C%E5%AE%8C%E5%85%A8%E8%83%8C%E5%8C%85/
        int[][] dp = new int[coins.length][amount + 1];
        for (int j = 0; j < dp[0].length; j++) {
            if (coins[0] > j) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = j / coins[0];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (coins[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    for (int k = 0; k * coins[i] <= j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i]] + k);
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
