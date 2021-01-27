package 并查集;

import java.util.*;

/**
 * @author: created by ponlanby
 * @date:2021/1/18
 */
public class Lc_721_账户合并 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i=1; i<size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailCount++);
                    emailToName.put(email, name);
                }
            }
        }

        UnionFind unionFind = new UnionFind(emailCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i=2; i<size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                unionFind.union(firstIndex, nextIndex);
            }
        }

        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = unionFind.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmails.put(index, account);
        }

        List<List<String>> merged = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }

        return merged;
    }

    private class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
            }
        }

        // 寻找根节点
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            parent[find(y)] = find(x);
        }
    }
}
