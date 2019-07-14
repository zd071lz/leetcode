package leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 */
public class Solution784 {
    public List<String> letterCasePermutation(String S) {
        List<String> out = new LinkedList();
        StringBuffer sb = new StringBuffer(S.length());
        helper(S, out, sb, 0);
        return out;
    }

    public void helper(String S, List<String> out, StringBuffer sb, int i) {
        if (S.length() == i) {
            out.add(sb.toString());
            return;
        }
        char c = S.charAt(i);
        sb.append(c);
        helper(S, out, sb, i + 1);
        sb.deleteCharAt(i);
        if (c >= 'A' && c <= 'Z') {
            sb.append((char)(c+32));
            helper(S, out, sb, i + 1);
            sb.deleteCharAt(i);
        }
        if (c >= 'a' && c <= 'z') {
            sb.append((char)(c-32));
            helper(S, out, sb, i + 1);
            sb.deleteCharAt(i);
        }
    }
}
