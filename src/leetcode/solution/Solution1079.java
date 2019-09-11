package leetcode.solution;

public class Solution1079 {
    public int numTilePossibilities(String tiles) {
        int[] counter = new int[26];
        for (Character c : tiles.toCharArray()) {
            counter[c - 'A']++;
        }
        return dfs(counter);
    }
    public int dfs(int[] counter) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (counter[i] == 0) {
                continue;
            }
            res += 1;
            counter[i] -= 1;
            res += dfs(counter);
            counter[i] += 1;
        }
        return res;
    }
}
