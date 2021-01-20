package leetcode.unionfind;

import java.util.*;

public class Leetcode721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> e2n = new HashMap<>();
        Map<String, Integer> e2i = new HashMap<>();
        int emailsCount = 0;
        for (List<String> a : accounts) {
            String name = a.get(0);
            for (int i = 1; i < a.size(); i++) {
                if(!e2i.containsKey(a.get(i))){
                    e2i.put(a.get(i), emailsCount++);
                    e2n.put(a.get(i), name);
                }
            }
        }
        UnionFind uf = new UnionFind(e2n.size());
        for (List<String> a : accounts) {
            String firstEmail = a.get(1);
            int firstIndex = e2i.get(firstEmail);
            for (int i = 2; i < a.size(); i++) {
                String nextEmail = a.get(i);
                int nextIndex = e2i.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }

        Map<Integer, List<String>> i2e = new HashMap<>();
        for (Map.Entry<String, Integer> e : e2i.entrySet()) {
            int x = uf.find(e.getValue());
            List<String> list = i2e.computeIfAbsent(x, k -> new LinkedList<>());
            list.add(e.getKey());
        }
        List<List<String>> merged = new ArrayList<>();
        for (List<String> emails : i2e.values()) {
            Collections.sort(emails);
            String name = e2n.get(emails.get(0));
            List<String> a = new LinkedList<>();
            a.add(name);
            a.addAll(emails);
            merged.add(a);
        }
        return merged;
    }
    private class UnionFind {
        private int ids[];
        UnionFind(int n) {
            ids = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
            }
        }

        public int find(int x) {
            if (ids[x] == x) {
                return x;
            }
            return find(ids[x]);
        }

        public void union(int x1, int x2) {
            ids[find(x1)] = find(x2);
        }
    }
}
