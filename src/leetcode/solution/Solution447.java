package leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int dist = (points[i][0] - points[j][0])*(points[i][0] - points[j][0])
                        +(points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
                Integer count = map.getOrDefault(dist, 0);
                ans += count * 2;
                map.put(dist, count + 1);
            }
        }
        return ans;
    }
}
