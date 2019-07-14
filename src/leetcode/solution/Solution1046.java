package leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            priorityQueue.add(stones[i]);
        }
        while (priorityQueue.size() > 1) {
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            if (x != y) {
                priorityQueue.add(Math.abs(x - y));
            }
        }
        return priorityQueue.size() == 1 ? priorityQueue.poll() : 0;
    }
}
