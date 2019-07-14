package leetcode.solution;

/**
 * 1047. 删除字符串中的所有相邻重复项
 */
public class Solution1047 {
    public static String removeDuplicates(final String S) {
//        final Stack<Character> stack = new Stack();
        StringBuffer sb = new StringBuffer(S.length());
        for (int i = 0; i < S.length(); i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == S.charAt(i)) {

                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
