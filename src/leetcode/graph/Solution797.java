package leetcode.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。
 */
public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        tmp.add(0);
        dfs(graph, 0);
        return ans;
    }
    private List<List<Integer>> ans = new LinkedList();
    private List<Integer> tmp = new LinkedList();
    public void dfs(int[][] graph,int x ) {
        if (x == graph.length -1) {
            ans.add(new LinkedList(tmp));
            return;
        }
        for (int i = 0; i < graph[x].length; i++) {
            tmp.add(graph[x][i]);
            dfs(graph, graph[x][i]);
            tmp.remove(tmp.size()-1);
        }
    }
}
