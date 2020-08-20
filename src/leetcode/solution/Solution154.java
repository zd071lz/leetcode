package leetcode.solution;

/**
 * @author okr
 */
public class Solution154 {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = (h - l)/2 + l;
            if (nums[m] < nums[h])
                h = m;
            else if (nums[m] > nums[h])
                l = m + 1;
            else
                h -= 1;

        }
        return nums[l];
    }
}
