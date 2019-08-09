package leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution506 {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] strs = new String[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = nums.length - i;
            if (pos == 1) {
                strs[map.get(nums[i])] = "Gold Medal";
            } else if (pos == 2) {
                strs[map.get(nums[i])] = "Silver Medal";
            } else if (pos == 3) {
                strs[map.get(nums[i])] = "Bronze Medal";
            } else {
                strs[map.get(nums[i])] = String.valueOf(pos);
            }
        }
        return strs;
    }
}
