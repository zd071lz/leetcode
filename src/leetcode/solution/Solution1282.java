package leetcode.solution;

import java.util.*;

/**
 *
 */
public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (groupSizes[i] == 1) {
                List<Integer> tmp = new ArrayList<>(1);
                tmp.add(i);
                ans.add(tmp);
            } else {
                List<Integer> list = map.get(groupSizes[i]);
                if (list == null) {
                    list = new ArrayList<>(groupSizes[i]);
                    map.put(groupSizes[i], list);
                }
                list.add(i);
                if (list.size() == groupSizes[i]) {
                    ans.add(list);
                    map.remove(groupSizes[i]);
                }
            }
        }
        return ans;
    }

}
