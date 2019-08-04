package leetcode.solution;

import java.util.HashSet;
import java.util.Set;

public class Solution888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        int sumB = 0;
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
            setB.add(B[i]);
        }
        int d = (sumB-sumA) / 2;
        for (int i = 0; i < A.length; i++) {
            if (setB.contains(A[i] + d)) {
                return new int[]{A[i],A[i] + d};
            }
        }
        return null;
    }
}
