package leetcode.solution;

import java.util.Arrays;

public class Solution824 {
    public String toGoatLatin(String S) {
        String[] strs = S.split(" ");
        char[] a = new char[strs.length];
        Arrays.fill(a, 'a');
        StringBuffer sb = new StringBuffer(S.length() + strs.length * 2 + (1 + strs.length) * strs.length / 2);
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].charAt(0) == 'a' ||
                    strs[i].charAt(0) == 'e' ||
                    strs[i].charAt(0) == 'i' ||
                    strs[i].charAt(0) == 'o' ||
                    strs[i].charAt(0) == 'u' ||
                    strs[i].charAt(0) == 'A' ||
                    strs[i].charAt(0) == 'E' ||
                    strs[i].charAt(0) == 'I' ||
                    strs[i].charAt(0) == 'O' ||
                    strs[i].charAt(0) == 'U'
            ) {
                sb.append(strs[i]).append("ma");
            } else {
                sb.append(strs[i].substring(1)).append(strs[i].charAt(0)).append("ma");
            }
            sb.append(a, 0, i + 1);
            if (i != strs.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
