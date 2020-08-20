package leetcode.solution;

/**
 * @author okr
 */
public class Solution921 {
    public int minAddToMakeValid(String S) {
        int ans = 0;
        int bal = 0;
        for (int i = 0; i < S.length(); i++) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            if (bal == -1) {
                ans++;
                bal++;
            }
        }
        return ans + bal;
    }
}
