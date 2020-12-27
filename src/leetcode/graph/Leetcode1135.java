package leetcode.graph;

import java.util.*;

/**
 * 1135. 最低成本联通所有城市
 * 地图上有 N 座城市 1 ~ N。
 * 给出一些 conections，其中 conections[i] = [city1, city2, cost] 表示将城市 city1 和城市 city2 连接所要的成本，连接是双向的。
 * 返回连接所有城市的最小成本，如果无法连接所有城市，返回 -1。
 * TODO plus
 */
public class Leetcode1135 {
    PriorityQueue<int[]> pq;
    boolean[] marked;
    public int minimumCost(int N, int[][] connections) {
        int ans = 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1], w = edge[2];
            List<int[]> list1 = graph.get(u);
            if (list1 == null) {
                list1 = new LinkedList<>();
                graph.put(u, list1);
            }
            list1.add(new int[]{v,w});
            List<int[]> list2 = graph.get(v);
            if (list2 == null) {
                list2 = new LinkedList<>();
                graph.put(v, list2);
            }
            list2.add(new int[]{u,w});
        }
        pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        visit(graph, 0);
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0];
            int w = poll[1];
            if (marked[u]) {
                continue;
            } else {
                ans += w;
                visit(graph, u);
            }
        }
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i]) {
                return -1;
            }
        }
        return ans;
    }
    public void visit(Map<Integer, List<int[]>> graph, int v) {
        marked[v] = true;
        List<int[]> ints = graph.get(v);
        for (int[] e : ints) {
            if (marked[e[0]]) {
                pq.offer(e);
            }
        }
    }
}
