package leetcode.solution;

/**
 * @author okr
 */
public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int i = 0; i < nums.length; i++) {
            bitmask ^= nums[i];
        }
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & diff) != 0) {
                x ^= nums[i];

            }
        }

        return new int[]{x, x ^ bitmask};
    }

    public static void main(String[] args) {
        int i = 6;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(-i);
        System.out.println(Integer.toBinaryString(-i));
        System.out.println(Integer.toBinaryString(i&-i));
    }
}
