package leetcode.solution;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            left.putIfAbsent(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int key :count.keySet()) {
            if (count.get(key) == degree) {
                ans = Math.min(ans, right.get(key) - left.get(key) + 1);
            }
        }
        return ans;
    }
}
