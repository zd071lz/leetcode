package leetcode.solution;

import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        while (true) {
            int s = 0;
            while (n > 0) {
                int x = n % 10;
                s += x * x;
                n = n / 10;
            }
            if (s == 1) {
                return true;
            }
            if (set.contains(s)) {
                return false;
            }
            set.add(s);
            n = s;
        }
    }
}
