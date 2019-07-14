import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //DFS
//    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
//    public void dfs(char[][] grid, int x, int y) {
//        int row_max = grid.length;
//        int col_max = grid[0].length;
//        if (x < 0 || x >= row_max || y < 0 || y >= col_max || grid[x][y] == '0')
//            return;
//        grid[x][y] = '0';
//        for (int i = 0; i < directions.length; i++) {
//            dfs(grid, x + directions[i][0], y + directions[i][1]);
//        }
//    }
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int row = grid.length;
//        int col = grid[0].length;
//        int count = 0;
//        for (int x = 0; x < row; x++) {
//            for (int y = 0; y < col; y++) {
//                if (grid[x][y] == '1') {
//                    count++;
//                    dfs(grid, x, y);
//                }
//            }
//        }
//        return count;
//    }
    //BFS
    // int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    // public void bfs(char[][] grid, int x, int y) {
    //     grid[x][y] = '0';
    //     int row_max = grid.length;
    //     int col_max = grid[0].length;
    //     Queue<Integer> queue = new LinkedList<>();
    //     queue.add(x * col_max + y);
    //     while (!queue.isEmpty()) {
    //         int num = queue.remove();
    //         x = num / col_max;
    //         y = num % col_max;
    //         for (int i = 0; i < directions.length; i++) {
    //             int cur_x = x + directions[i][0];
    //             int cur_y = y + directions[i][1];
    //             if (cur_x >= 0 && cur_x < row_max && cur_y >= 0 && cur_y < col_max && grid[cur_x][cur_y] == '1') {
    //                 grid[cur_x][cur_y] = '0';
    //                 queue.add(cur_x * col_max + cur_y);
    //             }
    //         }
    //     }
    // }
    // public int numIslands(char[][] grid) {
    //     if (grid == null || grid.length == 0) {
    //         return 0;
    //     }
    //     int row = grid.length;
    //     int col = grid[0].length;
    //     int count = 0;
    //     for (int x = 0; x < row; x++) {
    //         for (int y = 0; y < col; y++) {
    //             if (grid[x][y] == '1') {
    //                 count++;
    //                 bfs(grid, x, y);
    //             }
    //         }
    //     }
    //     return count;
    // }
    class UnionFind {
        private int count = 0;
        private int[] roots;
        private int[] rank;
        public UnionFind(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            roots = new int[row * col];
            rank = new int[row * col];
            for (int x = 0; x < row; x++) {
                for (int y= 0; y < col; y++) {
                    if (grid[x][y] == '1') {
                        roots[x * col + y] = x * col + y;
                        count++;
                    }
                    rank[x * col + y] = 0;
                }
            }
        }
        public int find(int i) {
            if (roots[i] != i)
                roots[i] = find(roots[i]);
            return roots[i];
        }
        public void union(int p, int q) {
            int root_p = find(p);
            int root_q = find(q);
            if (root_q != root_p) {
                if (rank[root_p] > rank[root_q]) {
                    roots[root_q] = root_p;
                } else if (rank[root_p] < rank[root_q]) {
                    roots[root_p] = root_q;
                } else {
                    roots[root_q] = root_p;
                    rank[root_p] += 1;
                }
                count--;
            }
        }
        public int getCount() {
            return count;
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (grid[x][y] == '1') {

                    if (x + 1 < row && grid[x + 1][y] == '1')
                        uf.union(x * col + y, (x + 1) * col + y);
                    if (y + 1 < col && grid[x][y + 1] == '1')
                        uf.union(x * col + y, x * col + y + 1);
                }
            }
        }
        return uf.getCount();
    }
}