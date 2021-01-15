package leetcode.backtrack;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 */
public class Leetcode17 {

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            char[] digit = digits.toCharArray();
            helper(digit, 0);
        }
        return ans;
    }
    private List<String> ans = new LinkedList<>();
    private StringBuffer tmp = new StringBuffer();
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public void helper(char[] digit, int s) {
        if (s == digit.length) {
            ans.add(tmp.toString());
            return;
        }
        char[] chars = phoneMap.get(digit[s]).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            tmp.append(chars[i]);
            helper(digit, s + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public static void main(String[] args) {
        new Leetcode17().letterCombinations("23");
    }
}
