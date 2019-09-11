package leetcode.solution;

import java.util.Arrays;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int one = 1;
        while (one == 1 && i >= 0) {
            int sum = digits[i] + one;
            digits[i] = sum % 10;
            one = sum / 10;
            i--;
        }
        if (one == 1) {
            int[] ans = new int[digits.length + 1];
            System.arraycopy(digits,0,ans,1,digits.length );
            ans[0] = 1;
            return ans;
        }
        return digits;
    }
}
