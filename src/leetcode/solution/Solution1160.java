package leetcode.solution;

import java.util.Arrays;

public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        int[] set = new int[26];
        for (Character c : chars.toCharArray()) {
            set[c - 'a']++;
        }
        for (String str : words) {
            if (str.length() > chars.length()) {
                continue;
            }
            int[] tmp = Arrays.copyOf(set, 26);
            boolean flag = true;
            for (Character c : str.toCharArray()) {
                if (tmp[c - 'a'] > 0) {
                    tmp[c - 'a']--;
                }else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans += str.length();
            }
        }
        return ans;
    }
}
