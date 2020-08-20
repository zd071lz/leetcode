package leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author okr
 */
public class Solution261 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(new LinkedList<>(), k, n, 1);
        return ans;
    }

    List<List<Integer>> ans = new LinkedList<>();

    public void helper(List<Integer> tmp, int k, int n, int x) {
        if (n == 0 && k == tmp.size()) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = x; i <= 9; i++) {
            if (n >= i) {
                n -= i;
                tmp.add(i);
                helper(tmp, k, n, i+1);
                tmp.remove(tmp.size() - 1);
                n += i;
            }
        }
    }
}

