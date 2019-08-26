package leetcode.solution;

public class Solution345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        char tmp;
        while (i < j) {
            if (!isVol(chars[i])) {
                i++;
                continue;
            }
            if (!isVol(chars[j])) {
                j--;
                continue;
            }
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public boolean isVol(char c) {
        return c=='a'||c=='A'||
                c=='e'||c=='E'||
                c=='i'||c=='I'||
                c=='o'||c=='O'||
                c=='u'||c=='U';
    }
}
