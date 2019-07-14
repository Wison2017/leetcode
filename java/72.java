public class UnionFind {
    //实现一个并查集，在查找的时候，会自动实现路径压缩
    private int[] roots;

    public UnionFind(int N) {
        roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
    }

    private int findRoot(int i) {
        int root = i;
        while (root != roots[root]) {
            root = roots[root];
        }
        while (roots[i] != root) {
            int temp = roots[i];
            roots[i] = root;
            i = temp;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int root_p = findRoot(p);
        int root_q = findRoot(q);
        if (root_p != root_q) {
            roots[p] = root_q;
        }

    }
}