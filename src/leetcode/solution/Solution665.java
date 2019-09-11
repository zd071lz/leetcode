package leetcode.solution;

public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        boolean f = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (f) {
                    return false;
                }
                int l = i - 2 >= 0 ? nums[i - 2] : Integer.MIN_VALUE;
                int r = i + 1 < nums.length ? nums[i + 1] : Integer.MAX_VALUE;
                if (l > r) {
                    return false;
                }
                if (nums[i - 1] >= l && nums[i - 1] <= r) {
                    nums[i ] = nums[i- 1] ;
                }else if (nums[i ] >= l && nums[i ] <= r) {
                    nums[i - 1] = nums[i];
                }else{
                    return false;
                }
                f = true;
            }
        }

        return true;
    }
}
