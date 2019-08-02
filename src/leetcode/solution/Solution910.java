package leetcode.solution;

import java.util.Arrays;

public class Solution910 {
    public int smallestRangeII(int[] A, int K) {
        if (A.length <= 1) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] - K;
        }
        int N = A.length - 1;
        int ans = A[N] - A[0];
        for (int i = 0; i < N; i++) {
            int min = Math.min(A[0]+2*K, A[i + 1]);
            int max = Math.max(A[N], A[i] + 2*K);
            ans = Math.min(ans, (max - min));
        }
        return ans;
    }

}
