package leetcode.graph;

import java.util.PriorityQueue;

/**
 * 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 */
public class Leetcode1584 {
    PriorityQueue<int[]> pq;
    boolean[] marked;
    public int minCostConnectPoints(int[][] points) {
        int ans = 0;
        marked = new boolean[points.length];
        pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        visit(points, 0);
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0];
            int w = poll[1];
            if (marked[u]) {
                continue;
            } else {
                ans += w;
                visit(points, u);
            }
        }
        return ans;
    }

    public void visit(int[][] points, int v) {
        marked[v] = true;
        for (int u = 0; u < points.length; u++) {
            if (!marked[u]) {
                int w = Math.abs(points[v][0] - points[u][0])
                        + Math.abs(points[v][1] - points[u][1]);
                pq.offer(new int[]{u, w});
            }

        }
    }
}
