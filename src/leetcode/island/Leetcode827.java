package leetcode.island;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 827. 最大人工岛
 * 在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
 *
 * 进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
 *
 * 示例 1:
 *
 * 输入: [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 *
 * 输入: [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 *
 * 输入: [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * 说明:
 *
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/making-a-large-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode827 {
    public int largestIsland(int[][] grid) {
        int ans = 0;
        if (grid == null || grid.length == 0) {
            return ans;
        }
        int id = 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int ret = dfs(grid, i, j, id);
                    map.put(id, ret);
                    id++;
                }
            }
        }
        if (map.size() == 1) {
            int f = grid.length * grid[0].length;
            if (map.get(2) == f) {
                return f;
            }
        }
        map.put(0, 0);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    set.add(helper(grid, i - 1, j));
                    set.add(helper(grid, i + 1, j));
                    set.add(helper(grid, i, j - 1));
                    set.add(helper(grid, i, j + 1));
                    int x = 0;
                    for (int k : set) {
                        x += map.get(k);
                    }
                    set.clear();
                    ans = Math.max(ans, x);
                }
            }
        }
        return ans + 1;
    }

    public int helper(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            return  grid[i][j] ;
        }
        return 0;
    }
    public int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = id;
        int ret = 1;
        ret += dfs(grid, i - 1, j, id);
        ret += dfs(grid, i + 1, j, id);
        ret += dfs(grid, i, j - 1, id);
        ret += dfs(grid, i, j + 1, id);
        return ret;
    }
}
