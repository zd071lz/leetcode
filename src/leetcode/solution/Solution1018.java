package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>(A.length);
        int mod = 0;
        for (int i = 0; i < A.length; i++) {
            mod = (mod << 1) % 5 + (A[i] == 1 ? 1 : 0);
            ans.add(mod % 5 == 0);
        }
        return ans;
    }
}
