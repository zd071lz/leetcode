package leetcode.solution;

public class Solution1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int len = R * C;
        int[][] ans = new int[len][2];
        int pos = 1;
        ans[0][0] = r0;
        ans[0][1] = c0;
        int loop1 = Math.max(r0 + c0, R - 1 - r0 + C - 1 - c0);
        int loop2 = Math.max(R - 1 - r0 + c0, r0 + C - 1 - c0);
        int loop = Math.max(loop1, loop2);
        int bufR, bufC;
        for (int i = 1; i <= loop; i++) {
            for (int j = 0; j < i; j++) {
                bufR = r0 - i + j;
                bufC = c0 - j;
                if (bufR >= 0 && bufC >= 0) {
                    ans[pos][0] = bufR;
                    ans[pos][1] = bufC;
                    pos++;
                }
                bufR = r0 + j;
                bufC = c0 - i + j;
                if (bufR < R && bufC >= 0) {
                    ans[pos][0] = bufR;
                    ans[pos][1] = bufC;
                    pos++;
                }
                bufR = r0 + i - j;
                bufC = c0 + j;
                if (bufR < R && bufC < C) {
                    ans[pos][0] = bufR;
                    ans[pos][1] = bufC;
                    pos++;
                }
                bufR = r0 - j;
                bufC = c0 + i - j;
                if (bufR >= 0 && bufC < C) {
                    ans[pos][0] = bufR;
                    ans[pos][1] = bufC;
                    pos++;
                }
            }
        }
        return ans;
    }
}
