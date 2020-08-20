package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author okr
 */
public class Solution1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = candies[i] > max ? candies[i] : max;
        }
        for (int i = 0; i < candies.length; i++) {
            ans.add(candies[i] + extraCandies >= max);
        }
        return ans;
    }
}
