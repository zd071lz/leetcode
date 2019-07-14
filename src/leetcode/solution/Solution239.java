package leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 1) {
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            if (i + 1 >= k) {
                ans[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
