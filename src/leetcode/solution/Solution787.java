package leetcode.solution;

import java.util.*;

public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ans = Integer.MAX_VALUE;
        map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            Map<Integer, Integer> srcMap = map.get(flights[i][0]);
            if (srcMap == null) {
                srcMap = new HashMap<>();
                map.put(flights[i][0], srcMap);
            }
            srcMap.put(flights[i][1], flights[i][2]);
        }
        //System.out.println(map);
        helper(src, K, dst, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int ans;
    Map<Integer, Map<Integer, Integer>> map;

    public void helper(int _src, int K, int dst, int curCost) {
        if (_src == dst) {
            ans = curCost;
            return;
        }
        if (K < 0) {
            return;
        }
        Map<Integer, Integer> srcMap = map.get(_src);
        if (srcMap == null) {
            return;
        }
        for (Map.Entry<Integer, Integer> e : srcMap.entrySet()) {
            int _dst = e.getKey();
            int _cost = e.getValue();
            if (curCost + _cost >= ans) continue;
            helper(_dst, K - 1, dst, curCost + _cost);
        }
    }

}
