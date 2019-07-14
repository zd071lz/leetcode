package leetcode.solution;

/**
 * 997. 找到小镇的法官
 */
public class Solution997 {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];
        for (int i = 0; i < trust.length; i++) {
            outdegree[trust[i][0]] += 1;
            indegree[trust[i][1]] += 1;
        }
        for (int i = 1; i < N+1; i++) {
            if (outdegree[i] == 0 && indegree[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
