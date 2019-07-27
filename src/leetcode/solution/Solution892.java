package leetcode.solution;

public class Solution892 {
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                ans += helper(grid, i - 1, j, grid[i][j]);
                ans += helper(grid, i + 1, j, grid[i][j]);
                ans += helper(grid, i, j - 1, grid[i][j]);
                ans += helper(grid, i, j + 1, grid[i][j]);
                ans += 2;
            }
        }
        return ans;
    }

    public int helper(int[][] grid, int i, int j, int h) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return h;
        }
        if (h > grid[i][j]) {
            return h - grid[i][j];
        }
        return 0;
    }
}
