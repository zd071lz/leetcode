package leetcode.unionfind;

/**
 * @author okr
 */
public class Leetcode959 {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        UnionSet unionSet = new UnionSet(4 * N * N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i].charAt(j) == ' ') {
                    unionSet.union(i * N * 4 + j * 4, i * N * 4 + j * 4 + 1);
                    unionSet.union(i * N * 4 + j * 4 + 1, i * N * 4 + j * 4 + 2);
                    unionSet.union(i * N * 4 + j * 4 + 2, i * N * 4 + j * 4 + 3);
                } else if (grid[i].charAt(j) == '/') {
                    unionSet.union(i * N * 4 + j * 4, i * N * 4 + j * 4 + 3);
                    unionSet.union(i * N * 4 + j * 4 + 1, i * N * 4 + j * 4 + 2);
                } else if (grid[i].charAt(j) == '\\') {
                    unionSet.union(i * N * 4 + j * 4, i * N * 4 + j * 4 + 1);
                    unionSet.union(i * N * 4 + j * 4 + 2, i * N * 4 + j * 4 + 3);
                }
                if (i - 1 >= 0) {
                    unionSet.union(i * N * 4 + j * 4, (i - 1) * N * 4 + j * 4 + 2);
                }
                if (j + 1 < N) {
                    unionSet.union(i * N * 4 + j * 4 + 1, i * N * 4 + (j + 1) * 4 + 3);
                }
                if (i + 1 < N) {
                    unionSet.union(i * N * 4 + j * 4 + 2, (i + 1) * N * 4 + j * 4);
                }
                if (j - 1 >= 0) {
                    unionSet.union(i * N * 4 + j * 4 + 3, i * N * 4 + (j - 1) * 4 + 1);
                }
            }
        }
        return unionSet.getCount();
    }

    class UnionSet {
        int[] ids;
        int count;

        UnionSet(int n) {
            count = n;
            ids = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
            }
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (ids[x] == x) {
                return x;
            }
            return find(ids[x]);
        }

        public void union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if (px1 == px2) {
                return;
            }
            count--;
            ids[px1] = px2;
        }
    }

    public static void main(String[] args) {
        System.out.println("\\/".length());
    }
}
