package leetcode.solution;

public class Solution917 {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (!Character.isAlphabetic(chars[i])) {
                i++;
                continue;
            }
            if (!Character.isAlphabetic(chars[j])) {
                j--;
                continue;
            }
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
    }
}
