package leetcode.solution;

public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int l = 0, h = nums.length-1, m;
        while (l <= h) {
            m = (l + h) >> 1;
            if (m - 1 >= 0&&m + 1 < nums.length && nums[m] != nums[m + 1]&& nums[m] != nums[m - 1]) {
                return nums[m];
            }
            if (m - 1 < 0&&m + 1 < nums.length && nums[m] != nums[m + 1]) {
                return nums[m];
            }
            if (m - 1 >= 0&&m + 1 >= nums.length && nums[m] != nums[m - 1]) {
                return nums[m];
            }
            if (m - 1 >= 0 && nums[m] == nums[m - 1]) {
                m = m - 1;
            }
            if (m % 2 == 0) {
                l = m+2;
            } else if(m % 2 == 1){
                h = m;
            }
        }
        return -1;
    }
}
