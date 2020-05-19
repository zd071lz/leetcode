package leetcode.solution;

/**
 *
 */
public class Solution1111 {
    public int[] maxDepthAfterSplit(String seq) {
        char[] chars = seq.toCharArray();
        int[] ans = new int[chars.length];
        int dep = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                dep++;
                ans[i] = dep % 2;
            } else {
                ans[i] = dep % 2;
                dep--;
            }
        }
        return ans;
    }
}
