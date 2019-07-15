package leetcode.solution;

/**
 * 1009. 十进制整数的反码
 */
public class Solution1009 {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        return (~N) & ((Integer.highestOneBit(N) << 1) - 1);
    }
}
