class Solution {
    public int totalNQueens(int n) {
        return dfs(0, 0, 0, 0, 0, n);
    }
    public int dfs(int row, int col, int xy_sum, int xy_sub, int count, int n) {
        if (row >= n) {
            count++;
            return count;
        }
        int bits = (~(col | xy_sum | xy_sub)) & ((1 << n) - 1);
        while (bits > 0) {
            bit = bits & -bits;
            count = dfs(row + 1, col | bit, (xy_sum | bit) << 1, (xy_sub | bit) >> 1, count, n);
            bits &= bits - 1;
        }
        return count;
    }

}