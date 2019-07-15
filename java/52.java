class Solution {
    public int totalNQueens(int n) {
        int[] xy_sum = new int[2*n-1];
        int[] xy_sub = new int[2*n-1];
        int[] cols = new int[n];
        return dfs(0, 0, xy_sum, xy_sub, cols, n);
    }

    public int dfs(int row, int count, int[] xy_sum, int[] xy_sub, int[] cols, int n) {
        if (row >= n) {
            count++;
            return count;
        }
        int x = row;
        for (int y = 0; y < n; y++) {
            if (cols[y] == 0 && xy_sum[x + y] == 0 && xy_sub[x - y + n - 1] == 0) {
                cols[y] = 1; xy_sum[x + y] = 1; xy_sub[x - y + n - 1] = 1;
                count = dfs(row + 1, count, xy_sum, xy_sub, cols, n);
                cols[y] = 0; xy_sum[x + y] = 0; xy_sub[x - y + n - 1] = 0;
            }
        }
        return count;
    }
}
