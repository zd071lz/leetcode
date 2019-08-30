package leetcode.solution;

public class Solution925 {
    public boolean isLongPressedName(final String name, final String typed) {
        char[] nc = name.toCharArray();
        char[] tc = typed.toCharArray();
        int i = 0, j = 0;
        while (i < nc.length || j < tc.length) {
            char ci = i < nc.length? nc[i] :nc[nc.length-1];
            if ( j >= tc.length) {
                return false;
            }
            char cj = tc[j];
            if (ci==cj) {
                if (i < nc.length) {
                    i++;
                }
                j++;
            }else{
                if (i > 0 && cj == nc[i - 1]) {
                    j++;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
