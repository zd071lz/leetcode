package leetcode.solution;

public class Solution1108 {
    public String defangIPaddr(String address) {
        char[] chars = address.toCharArray();
        char[] ans = new char[chars.length + 6];
        int ansPos = 0,charsPos = 0;
        while (charsPos < chars.length) {
            if (chars[charsPos] == '.') {
                ans[ansPos++] =  '[';
                ans[ansPos++] = chars[charsPos++];
                ans[ansPos++] =  ']';
            }else {
                ans[ansPos++] = chars[charsPos++];
            }
        }
        return new String(ans);
    }
}
