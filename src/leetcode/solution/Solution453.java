package leetcode.solution;

public class Solution453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        int k = sum - min * (nums.length - 1);
        return k - min;
    }
}
