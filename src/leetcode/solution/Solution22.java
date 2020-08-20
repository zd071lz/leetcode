package leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author okr
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>(0);
        }
        List<List<String>> dp = new ArrayList<>(n + 1);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}
