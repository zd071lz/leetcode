package leetcode.solution;

public class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length <= 1) {
            return true;
        }
        int[] f = new int[26];
        char[] ord = order.toCharArray();
        for (int i = 0; i < ord.length; i++) {
            f[ord[i] - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words[i].length()+1; j++) {
                int x = j>=words[i-1].length()?-1:f[words[i-1].charAt(j)-'a'];
                int y = j>=words[i].length()?-1:f[words[i].charAt(j)-'a'];
                if (x > y) {
                    return false;
                }
                if (x < y) {
                    continue;
                }
            }
        }
        return true;
    }

}
