package leetcode.solution;

import java.util.PriorityQueue;

public class Solution414 {
    public int thirdMax(final int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue(3);

        for (int i = 0; i < nums.length; i++) {
            if (q.contains(nums[i])) {
                continue;
            }
            if (q.size() < 3) {
                q.add(nums[i]);
            } else {
                if (q.peek() < nums[i]) {
                    q.poll();
                    q.add(nums[i]);
                }
            }
        }
        if (q.size() < 3 && q.size() > 1) {
            q.poll();
        }
        return q.peek();
    }

}
