package leetcode.solution;

/**
 * @author okr
 */
public class Solution1504 {
    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            int len = 0;
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    len++;
                } else {
                    len = 0;
                }
                mat[i][j] = len;
            }
        }
    }

}
