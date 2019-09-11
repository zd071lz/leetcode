package leetcode.solution;

import java.util.BitSet;

public class Solution204 {
    public int countPrimes(int n) {
        boolean[] b = new boolean[n];
        for (int i = 2; i*i < n; i++) {
            b[i] = true;
        }
        for (int i = 2; i*i < n; i++) {
            if (b[i]) {
                for (int j = i*i; j < n; j+=i) {
                    b[j] = false;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans+=b[i]?1:0;
        }
        return ans;
    }


}
