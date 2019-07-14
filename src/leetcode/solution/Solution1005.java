package leetcode.solution;

import java.util.Arrays;

public class Solution1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i = 0;
        while (i < A.length && K > 0) {
            if (A[i] < 0) {
                A[i] *= -1;
                K--;
                i++;
            } else {
                break;
            }
        }
        if (K % 2 == 1) {
            if (i - 1 < 0) {
                A[i] *= -1;
            } else if (i >= A.length) {
                A[i - 1] *= -1;
            } else {
                if (A[i] > A[i - 1]) {
                    A[i - 1] *= -1;
                } else {
                    A[i] *= -1;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < A.length; j++) {
            ans += A[j];
        }
        return ans;
    }

}
