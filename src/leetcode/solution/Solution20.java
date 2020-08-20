package leetcode.solution;

import java.util.*;

/**
 * @author okr
 */
public class Solution20 {
    static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }
    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (stack.size() == 0 || map.containsKey(chars[i])) {
                stack.push(chars[i]);
            } else if (map.get(stack.peek()) != null && map.get(stack.peek()).equals(chars[i])) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.size() == 0;
    }
}
