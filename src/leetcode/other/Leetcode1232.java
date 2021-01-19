package leetcode.other;

public class Leetcode1232 {
    /*
     * 叉乘 a * b
     * = | x1, y1 | = x1 * y2 - y1 * x2
     *   | x2, y2 |
     * 若结果小于 0，表示向量 b 在向量 a 的顺时针方向；
     * 若结果大于 0，表示向量 b 在向量 a 的逆时针方向；
     * 若结果为 0，表示向量 b 与向量 a 平行；
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[1][0] - coordinates[0][0];
        int y1 = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x2 = coordinates[i][0] - coordinates[0][0];
            int y2 = coordinates[i][1] - coordinates[0][1];
            if (x1 * y2 - x2 * y1 != 0) {
                return false;
            }
        }
        return true;
    }
}
