package leetcode.solution;

public class Solution1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] t = new int[60];
        for (int i = 0; i < time.length; i++) {
            t[time[i] % 60]++;
        }
        int ans = 0;
        for (int i = 1; i < 30; i++) {
            ans += t[i] * t[60 - i];
        }
        ans += (t[0] * (t[0] - 1) + t[30] * (t[30] - 1)) / 2;
        return ans;
    }
}
