package leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] set = new int[26];
        int licenseLen = 0;
        for (Character c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                set[c - 'a']++;
                licenseLen++;
            }
        }
        String ans = null;
        int[] tmp = new int[26];
        for (String word : words) {
            if (word.length() < licenseLen) {
                continue;
            }
            for (Character c : word.toLowerCase().toCharArray()) {
                tmp[c - 'a']++;
            }
            if (match(tmp, set)) {
                if (ans == null || ans.length() > word.length()) {
                    ans = word;
                }
            }
            Arrays.fill(tmp, 0);
        }
        return ans;
    }

    public boolean match(int[] tmp, int[] set) {
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] < set[i]) {
                return false;
            }
        }
        return true;
    }
}
