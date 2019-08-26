package leetcode.solution;

public class Solution504 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean nag = false;
        if (num < 0) {
            nag = true;
            num *= -1;
        }
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        if (nag) {
            sb.insert(0,"-");
        }
        return sb.toString();
    }
}
