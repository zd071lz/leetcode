package leetcode.solution;

public class Solution598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return 0;
        }
        int minA = ops[0][0];
        int minB = ops[0][1];
        for (int i = 0; i < ops.length; i++) {
            minA = Math.min(minA, ops[i][0]);
            minB = Math.min(minB, ops[i][1]);
        }
        return minA * minB;
    }
}
