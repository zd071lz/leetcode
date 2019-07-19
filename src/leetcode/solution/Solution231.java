package leetcode.solution;

/**
 * 231. 2的幂
 */
public class Solution231 {
    public static boolean isPowerOfTwo(final int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
