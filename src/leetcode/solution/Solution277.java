package leetcode.solution;

/**
 * 277. 搜寻名人
 * TODO plus Lintcode645
 * 题解 https://www.cnblogs.com/grandyang/p/5310649.html
 */
public class Solution277 {
    public int findCelebrity(int n) {
        //出度
        int[] outdegree = new int[n];
        //入度
        int[] indegree = new int[n];
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (knows(i, j)) {
                    outdegree[i]++;
                    indegree[j]++;
                }
                if (knows(j, i)) {
                    outdegree[j]++;
                    indegree[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0 && indegree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
    private boolean knows(int a, int b) {
        return false;
    }
}
