package leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length()==0&& B.length()==0) {
            return false;
        }
        if (A.length() != B.length()) {
            return false;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int max = 0;
        int c = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0)+1);
            if (a[i] != b[i]) {
                c++;
            }
            max = Math.max(max, map.get(a[i]));
        }
        for (int i = 0; i < b.length; i++) {
            map.put(b[i], map.getOrDefault(b[i], 0)-1);
            max = Math.max(max, map.get(a[i]));
        }
        for (Integer i : map.values()) {
            if (i != 0) {
                return false;
            }
        }
        if ((max > 1&&c == 0) || c == 2) {
            return true;
        }
        return false;
    }
}
