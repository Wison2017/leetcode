class Solution {
    int n = 3;
    int N = 9;
    int[][] rows = new int[N][N+1];
    int[][] cols = new int[N][N+1];
    int[][] box = new int[N][N+1];
    char[][] board;
    boolean find = false;

    public void placeNumber(int num, int row, int col) {
        int index_of_box = row/n*n + col/n;
        rows[row][num] += 1;
        cols[col][num] += 1;
        box[index_of_box][num] += 1;
        this.board[row][col] = (char)(num + '0');
    }

    public void removeNumber(int num, int row, int col) {
        int index_of_box = row/n*n + col/n;
        rows[row][num] -= 1;
        cols[col][num] -= 1;
        box[index_of_box][num] -= 1;
        this.board[row][col] = '.';
    }
    public boolean isValid(int num, int row, int col) {
        int index_of_box = row/n*n + col/n;
        if (rows[row][num] == 1) return false;
        if (cols[col][num] == 1) return false;
        if (box[index_of_box][num] == 1) return false;
        return true;
    }
    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] != '.') {
                    int num = Character.getNumericValue(board[row][col]);
                    placeNumber(num, row, col);
                }
            }
        }
        DFS(0,0);
    }
    public void DFS(int row, int col) {
        if (row == N - 1 && col == N) {
            find = true;
        } else if (col == N) {
            DFS(row + 1, 0);
        } else {
            if (board[row][col] == '.') {
                for (int num = 1; num <= N; num++) {
                    if (isValid(num, row, col)) {
                        placeNumber(num, row, col);
                        DFS(row, col + 1);
                        if (!find) removeNumber(num, row, col);
                    }
                }
            } else {
                DFS(row, col + 1);
            }
        }
    }
}
