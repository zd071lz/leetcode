package leetcode.unionfind;

public class Leetcode684 {
    public int[] findRedundantConnection(int[][] edges) {
        ids = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            ids[i] = i;
        }
        for (int i = 0; i <edges.length; i++) {
            if (connected(edges[i][0], edges[i][1])) {
                return edges[i];
            }
            union(edges[i][0], edges[i][1]);
        }
        return new int[0];
    }
    private int[] ids;
    private boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    private int find( int a) {
        if (a == ids[a]) {
            return a;
        }
        return find(ids[a]);
    }
    private void union( int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return;
        }
        ids[pa] = pb;
    }

//    private int find( int a) {
//        return ids[a];
//    }
//    private void union( int a, int b) {
//        int pa = find(a);
//        int pb = find(b);
//        if (pa == pb) {
//            return;
//        }
//        for (int i = 0; i < ids.length; i++) {
//            if (ids[i] == pa) {
//                ids[i] = pb;
//            }
//        }
//    }
}
