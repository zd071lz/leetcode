package leetcode.solution;

/**
 * @author okr
 */
public class Solution289 {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int c = countLive(board, i, j);
                if (board[i][j] == 1 && (c != 2 && c != 3)) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && c == 3) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int c = countLive(board, i, j);
                if (board[i][j] == 2 ) {
                    board[i][j] = 0;
                }
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int countLive(int[][] board, int i, int j) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        if (i - 1 >= 0 && board[i - 1][j] > 0) {
            count++;
        }
        if (j - 1 >= 0 && board[i][j - 1] > 0) {
            count++;
        }
        if (i + 1 < m && board[i + 1][j] > 0) {
            count++;
        }
        if (j + 1 < n && board[i][j + 1] > 0) {
            count++;
        }

        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j-1] > 0) {
            count++;
        }
        if (j - 1 >= 0 && i + 1 < m && board[i + 1][j - 1] > 0) {
            count++;
        }
        if (i + 1 < m && j + 1 < n && board[i + 1][j + 1] > 0) {
            count++;
        }
        if (i - 1 >= 0 && j + 1 < n && board[i - 1][j + 1] > 0) {
            count++;
        }

        return count;
    }
}
