import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            return false;
        int row_max = board.length;
        int col_max = board[0].length;
        boolean[][] flag = new boolean[row_max][col_max];
        for (int x = 0; x < row_max; x++) {
            for (int y = 0; y < col_max; y++) {
                if (board[x][y] == word.charAt(0)) {
                    flag[x][y] = true;
                    if (DFS(board, word.substring(1), x, y, flag) == true)
                        return true;
                    flag[x][y] = false;
                }
            }
        }
        return false;
    }
    private boolean DFS(char[][] board, String word, int origin_x, int origin_y, boolean[][] flag) {
        if (word.length() == 0) return true;
        for (int[] d : direction) {
            int x = origin_x + d[0];
            int y = origin_y + d[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length
                    && flag[x][y] == false && word.charAt(0) == board[x][y]) {
                flag[x][y] = true;
                if (DFS(board, word.substring(1), x, y, flag) == true)
                    return true;
                flag[x][y] = false;
            }
        }
        return false;
    }
}
