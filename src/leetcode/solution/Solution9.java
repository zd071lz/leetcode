package leetcode.solution;

public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int r = 0;
        int y = x;
        while (y > 0) {
            r = r * 10 + y % 10;
            y = y / 10;
        }
        if (r == x) {
            return true;
        }else {
            return false;
        }
    }
}
