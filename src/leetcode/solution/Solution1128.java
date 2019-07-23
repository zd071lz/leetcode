package leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution1128 {
    public static int numEquivDominoPairs(final int[][] dominoes) {
        int ans = 0;
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            final int g = Math.max(dominoes[i][0], dominoes[i][1]);
            final int l = Math.min(dominoes[i][0], dominoes[i][1]);
            final String key = l + "_" + g;
            int count = map.getOrDefault(key, 0);
            count++;
            map.put(key, count);

        }
        for (final Integer i : map.values()) {
            ans += i * (i - 1);
        }
        return ans / 2;
    }
}
