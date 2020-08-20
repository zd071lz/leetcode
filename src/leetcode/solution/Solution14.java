package leetcode.solution;

/**
 * @author okr
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuffer ans = new StringBuffer();
        char[] chars = strs[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return ans.toString();
                }
                if (strs[j].charAt(i) != chars[i]) {
                    return ans.toString();
                }
            }
            ans.append(chars[i]);
        }
        return ans.toString();
    }
}
