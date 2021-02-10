package leetcode.other;

/**
 * @author okr
 */
public class Leetcode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int ans = 0;
        int x = 0;
        int i = 0;
        int sum = 0;
        while( i < s.length()) {
            int abs = Math.abs(s.charAt(i) - t.charAt(i));
            if (sum + abs <= maxCost) {
                //前进
                sum += abs;
                i++;
            } else if (sum >= 0) {
                int xabs = Math.abs(s.charAt(x) - t.charAt(x));
                sum -= xabs;
                if (i == x) {
                    i++;
                }
                x++;
            }
            ans = Math.max(ans, i - x + 1);
        }
        return ans;
    }
}
