class Solution {
    class UnionFind {
        private int count = 0;
        private int[] roots;
        private int[] rank;
        public UnionFind(int[][] grid) {
            int row = grid.length;
            roots = new int[row];
            rank = new int[row];
            for (int x = 0; x < row; x++) {
                roots[x] = x;
                count++;
                rank[x] = 0;
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
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0)
            return 0;
        int length = M.length;
        UnionFind uf = new UnionFind(M);
        for (int x = 0; x < length; x++) {
            for (int y = x + 1; y < length; y++) {
                if (M[x][y] == 1) {
                    uf.union(x, y);
                }
            }
        }
        return uf.getCount();
    }
}