package leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
