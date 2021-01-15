package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 */
public class Leetcode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>(A.length);
        int t = 0;
        for (int i = 0; i < A.length; i++) {
            t = ((t << 1) + A[i]) % 5;
            ans.add(t == 0);
        }
        return ans;
    }
}
