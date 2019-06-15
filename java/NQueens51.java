import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        helper(0, new ArrayList<String>(), new boolean[n], new boolean[2*n-1], new boolean[2*n-1], result, n);
        return result;
    }
    private void helper(int row, List<String> board, boolean[] cols, boolean[] xy_sum, boolean[] xy_sub, List<List<String>> result, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (String s: board) {
                list.add(s);
            }
            result.add(list);
        } else {
            for (int y = 0; y < n; y++) {
                int x = row;
                if (!cols[y] && !xy_sum[x+y] && !xy_sub[x - y + n - 1]) {
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < n; i++) {
                        if (i == y) sb.append("Q");
                        else sb.append(".");
                    }
                    board.add(sb.toString());
                    cols[y] = true; xy_sum[x+y] = true; xy_sub[x-y+n-1] = true;

                    helper(row+1, board, cols, xy_sum, xy_sub,result, n);
                    board.remove(board.size() - 1);

                    cols[y] = false; xy_sum[x+y] = false; xy_sub[x-y+n-1] = false;
                }
            }
        }
    }
}
