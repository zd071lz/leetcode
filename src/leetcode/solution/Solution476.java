package leetcode.solution;

/**
 * 476. 数字的补数
 */
public class Solution476 {
    public int findComplement(int num) {
        return (~num) & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
