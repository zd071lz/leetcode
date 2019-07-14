package leetcode.solution;

import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0, pos = 0;
        while (pos < s.length) {
            if (g[ans] <= s[pos] && ans < g.length) {
                ans++;
            }
            pos++;
        }
        return ans;
    }
}
