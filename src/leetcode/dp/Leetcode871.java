package leetcode.dp;

public class Leetcode871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //用 dp[i] 表示加油i次的最大行驶英里数。
        long[] dp = new long[stations.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]) {//当前的油可以到达这个加油站
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                } else {//剪枝
                    break;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }
}
