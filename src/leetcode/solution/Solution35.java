package leetcode.solution;

/**
 * @author okr
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int ans = nums.length;

        while (l <= h) {
            int m = ((h - l) >> 1) + l;
            if (target <= nums[m]) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }

        }
        return ans;
    }
}
