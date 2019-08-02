package leetcode.solution;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] set = new int[26];
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            set[sc[i] - 'a']++;
        }
        char[] tc = t.toCharArray();
        for (int i = 0; i < tc.length; i++) {
            set[tc[i] - 'a']--;
        }
        for (int i = 0; i < set.length; i++) {
            if (set[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
