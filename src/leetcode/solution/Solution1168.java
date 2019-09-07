package leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1168 {
    private int[] id;
    private int count = 0;

    private int find(int a) {
        if (id[a] == a) return a;
        int root = find(id[a]);
        id[a] = root;
        return root;
    }

    private void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return;
        id[aRoot] = bRoot;
        count--;
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        id = new int[n + 1];
        count = n + 1;
        for (int i = 0; i <= n; i++)
            id[i] = i;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < wells.length; i++) {
            int[] wellPipe = {i + 1, 0, wells[i]};
            pq.offer(wellPipe);
        }
        for (int[] pipe: pipes) {
            pq.offer(pipe);
        }
        int res = 0;
        while (!pq.isEmpty() && count > 1) {
            int[] pipe = pq.poll();
            int from = pipe[0], to = pipe[1], cost = pipe[2];
            if (find(from) != find(to)) {
                res += cost;
                union(from, to);
            }
        }
        return res;
    }
}
