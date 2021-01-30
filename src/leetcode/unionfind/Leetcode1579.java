package leetcode.unionfind;

/**
 * @author okr
 */
public class Leetcode1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionSet unionSet1 = new UnionSet(n);
        UnionSet unionSet2 = new UnionSet(n);
        int t = 0;
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == 3) {
                if (!unionSet1.union(edges[i][1] - 1, edges[i][2] - 1)) {
                    t++;//多余的
                }
                unionSet2.union(edges[i][1] - 1, edges[i][2] - 1);
            }
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == 1) {
                if (!unionSet1.union(edges[i][1] - 1, edges[i][2] - 1)) {
                    t1++;//多余的
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == 2) {
                if (!unionSet2.union(edges[i][1] - 1, edges[i][2] - 1)) {
                    t2++;//多余的
                }
            }
        }
        if (unionSet1.getCount() == 1 && unionSet2.getCount() == 1) {
            return t + t1 + t2;
        } else {
            return -1;
        }
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
