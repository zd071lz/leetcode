package leetcode.solution;

/**
 * @author okr
 */
public class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        for (int k = 1; k < Math.min(row, col); k++) {
            for (int i = 0; i < row-k; i++) {
                for (int j = 0; j < col - k; j++) {

                    if (mat[i][j] > mat[i + 1][j+ 1]) {
                        int tmp = mat[i][j];
                        mat[i][j] = mat[i + 1][j + 1];
                        mat[i + 1][j + 1] = tmp;

                    }
                }
            }
        }
        return mat;
    }
}
