package offer;

/**
 * @author okr
 */
public class Offer4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int col = matrix.length - 1;
        int row = 0;
        while (col >= 0 && row < matrix[0].length) {
            if (matrix[col][row] == target) {
                return true;
            } else if (matrix[col][row] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Offer4().findNumberIn2DArray(new int[][]{{1, 4}, {2, 5}}, 2);
    }
}
