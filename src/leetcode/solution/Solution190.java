package leetcode.solution;

public class Solution190 {
    public  int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i))!=0) {
                ans += (1 << (31 - i));
            }
        }
        return ans;
    }
}
