package 并查集;

/**
 * @author: created by ponlanby
 * @date:2021/1/23
 */
public class Lc_1319_连通网络的操作次数 {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        UnionFind unionFind = new UnionFind(n);
        for (int[] conn : connections) {
            unionFind.union(conn[0], conn[1]);
        }

        return unionFind.getSetCount() - 1;
    }

    private class UnionFind {
        private int[] parent;
        private int[] size;
        private int n;
        // 当前连通分量数目
        private int setCount;

        public int getSetCount() {
            return setCount;
        }

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            this.n = n;
            this.setCount = n;
            for (int i=0; i<n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                return find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (size[rootX] < size[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            --setCount;
        }
    }
}
