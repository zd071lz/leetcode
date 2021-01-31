package leetcode.unionfind;

public class Leetcode839 {
    public int numSimilarGroups(String[] strs) {
        UnionSet unionSet = new UnionSet(strs.length);
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (check(strs[i], strs[j])) {
                    unionSet.union(i, j);
                }
            }
        }
        return unionSet.getCount();
    }

    public boolean check(String str1, String str2) {
        int t = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                t++;
            }
        }
        if (t == 2 || t == 0) {
            return true;
        }
        return false;
    }

    class UnionSet {
        int[] rank;
        int[] ids;
        int count;

        UnionSet(int n) {
            ids = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                ids[i] = i;
                rank[i] = 1;
            }
        }

        int getCount() {
            return count;
        }

        int find(int x) {
            if (ids[x] == x) {
                return x;
            }
            return find(ids[x]);
        }

        boolean union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if (px1 == px2) {
                return false;
            }
            count--;
            if (rank[px1] < rank[px2]) {
                ids[px1] = px2;
                rank[px2] += rank[px1];
            } else {
                ids[px2] = px1;
                rank[px1] += rank[px2];
            }
            return true;
        }
    }
}
