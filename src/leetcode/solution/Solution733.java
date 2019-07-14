package leetcode.solution;

/**
 * 733. 图像渲染
 */
public class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr, sc-1, oldColor, newColor);
        dfs(image, sr, sc+1, oldColor, newColor);
        dfs(image, sr-1, sc, oldColor, newColor);
        dfs(image, sr+1, sc, oldColor, newColor);
    }
}
