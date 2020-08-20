package leetcode.solution;

/**
 * @author okr
 */
public class Solution990 {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '=') {
                int idx1 = equations[i].charAt(0) - 'a';
                int idx2 = equations[i].charAt(3) - 'a';
                union(parent, idx1, idx2);
            }
        }
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '!') {
                int idx1 = equations[i].charAt(0) - 'a';
                int idx2 = equations[i].charAt(3) - 'a';
                if (find(parent, idx1) == find(parent, idx2)) {
                    return false;
                }

            }
        }
        return true;
    }
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }
    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

}
