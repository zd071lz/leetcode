package leetcode.solution;

public class Solution551 {
    public boolean checkRecord(String s) {
        boolean A = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                if (i > 0 && i < s.length() - 1 &&
                        s.charAt(i - 1) == 'L' && s.charAt(i + 1) == 'L') {
                    return false;
                }
            } else {
                if (s.charAt(i) == 'A') {
                    if (A) {
                        return false;
                    }
                    A = true;
                }
            }
        }
        return true;
    }
}
