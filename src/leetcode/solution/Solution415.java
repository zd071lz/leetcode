package leetcode.solution;

/**
 * @author okr
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0 || add > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int r = x + y + add;
            sb.append(r % 10);
            add = r / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
