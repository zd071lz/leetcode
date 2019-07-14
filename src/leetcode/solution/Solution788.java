package leetcode.solution;

public class Solution788 {
    public int rotatedDigits(int N) {
        byte[] d = new byte[N + 1];
        byte[] a = new byte[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            d[i] = -1;
            int i1 = d[i / 10] | a[i % 10];
            if (i1 == 0) {
                d[i] = 0;
            } else if (i1 == 1) {
                d[i] = 1;
                ans++;
            }
        }
        return ans;
    }
}
