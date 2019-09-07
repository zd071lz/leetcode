package leetcode.solution;

public class Solution409 {
    public static int longestPalindrome(String s) {
        int ans = 0;
        int[] r = new int[52];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i]>='a'?chars[i] - 'a'+26:chars[i] - 'A';
            if (r[idx] == 1) {
                r[idx] = 0;
                ans += 2;
            } else {
                r[idx] = 1;
            }
        }
        for (int i = 0; i < r.length; i++) {
            if (r[i] > 0) {
                ans++;
                break;
            }
        }
        return ans;
    }
}
