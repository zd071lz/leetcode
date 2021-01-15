package leetcode.unionfind;

/**
 * 947. 移除最多的同行或同列石头
 *
 */
public class Leetcode947 {
    public int removeStones(int[][] stones) {
        count = stones.length;
        ids = new int[stones.length];
        for (int i = 0; i < stones.length; i++) {
            ids[i] = i;
        }
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }
        return stones.length - count;
    }
    int[] ids;
    int count;

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
        ids[px1] = px2;
        count--;
    }
    
}
