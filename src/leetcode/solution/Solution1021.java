package leetcode.solution;

import java.util.Stack;

public class Solution1021 {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack();
        char[] chars = S.toCharArray();
        int pos = 0;
        for (int i = 0; i <chars.length ; i++) {
            if (stack.empty()) {
                stack.push(chars[i]);
                pos = i;
            }else if (stack.size() == 1 && stack.peek() == '(' && chars[i] == ')') {
                stack.pop();
                chars[pos] = ' ';
                chars[i] = ' ';
            } else if (stack.peek() == '(' && chars[i] == ')') {
                stack.pop();
            } else{
                stack.push(chars[i]);
            }
        }
        StringBuffer sb = new StringBuffer(S.length());
        for (int i = 0; i <chars.length; i++) {
            if (chars[i] != ' ') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
