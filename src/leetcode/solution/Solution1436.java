package leetcode.solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author okr
 */
public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> list : paths) {
            map.put(list.get(0), map.getOrDefault(list.get(0), 0)+1);
            map.putIfAbsent(list.get(1), 0);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue().equals(0)) {
                return e.getKey();
            }
        }
        return null;
    }
}