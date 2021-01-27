package 并查集;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: created by ponlanby
 * @date:2021/1/20
 */
public class Lc_1584_连接所有点的最小费用 {

    public static int minCostConnectPoints(int[][] points) {
        int result = 0;
        int num = points.length;
        List<Edge> edges = new ArrayList<>();
        // 初始化点-边结构
        for (int i=0; i<num; i++) {
            for (int j=i+1; j<num; j++) {
                Edge edge = new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                edges.add(edge);
            }
        }

        // 按边长度排序
        edges.sort(Comparator.comparingInt(e -> e.length));

        // 连通分量合并
        UnionFind unionFind = new UnionFind(num);
        for (Edge edge : edges) {
            result = unionFind.union(edge.start, edge.end, edge.length);
            if (-1 != result) {
                return result;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0}, {2,2}, {3,10}, {5,2}, {7,0}};
        System.out.println(minCostConnectPoints(points));
    }

    private static class UnionFind {
        // 记录节点的根
        private int[] parent;
        // 记录根节点的深度（用于优化）
        private int[] depth;
        // 记录每个连通分量的节点个数
        private int[] size;
        // 记录每个连通分量里的所有边长度
        private int[] length;
        // 记录节点个数
        int num;

        public UnionFind(int n) {
            parent = new int[n];
            depth = new int[n];
            size = new int[n];
            length = new int[n];
            num = n;
            for (int i=0; i<n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int union(int x, int y, int len) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                // 深度小的连通分量加到深度大的连通分量上，保证深度不会增加
                // 保证X为深度较大的连通分量，Y加到X上
                if (depth[rootX] < depth[rootY]) {
                    int tmp = rootX;
                    rootX = rootY;
                    rootY = tmp;
                }
                parent[rootY] = rootX;

                // XY深度相同则增加一层
                if (depth[rootX] == depth[rootY]) {
                    depth[rootX] += 1;
                }

                // 将rooty的节点数和边长度累加到rootx
                size[rootX] += size[rootY];
                length[rootX] += length[rootY] + len;

                // 如果某个连通分量的节点数 包含了所有节点，直接返回边长度
                if (size[rootX] == num) {
                    return length[rootX];
                }
            }
            return -1;
        }
    }

    private static class Edge {
        private int start;
        private int end;
        private int length;

        public Edge(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }
    }
}
