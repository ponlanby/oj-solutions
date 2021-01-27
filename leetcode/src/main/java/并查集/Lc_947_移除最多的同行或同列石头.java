package 并查集;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: created by ponlanby
 * @date:2021/1/16
 */
public class Lc_947_移除最多的同行或同列石头 {

    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();

        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }

        return stones.length - unionFind.getCount();
    }

    private class UnionFind {
        private Map<Integer, Integer> parent;
        // 连通分量数
        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind() {
            this.parent = new HashMap<>();
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }

            // 路径压缩
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return ;
            }

            parent.put(rootX, rootY);
            count--;
        }
    }
}
