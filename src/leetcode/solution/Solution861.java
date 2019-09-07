package leetcode.solution;

public class Solution861 {
    public int matrixScore(int[][] A) {
        int R = A.length, C = A[0].length;
        int ans = 0;
        for (int i = 0; i < R; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < C; j++) {
                    A[i][j] ^= 1;
                }
            }
        }
        for (int j = 0; j < C; j++) {
            int col = 0;
            for (int i = 0; i < R; i++) {
                col += A[i][j];
            }
            ans += Math.max(col, R - col) * (1 << (C - 1 - j));
        }
        return ans;
    }

}
