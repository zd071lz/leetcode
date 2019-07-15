package leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, setSize = 0, left = 0, right = 0;
        byte[] set = new byte[128];
        while (right < s.length()) {
            if (set[s.charAt(right)] == 0) {
                set[s.charAt(right++)] = 1;
                setSize++;
                res = Math.max(res, setSize);
            } else {
                set[s.charAt(left++)] = 0;
                setSize--;
            }
        }
        return res;
    }
}
