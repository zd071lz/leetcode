package leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]) + 1, i + 1};
            }else{
                map.put(target - numbers[i], i);
            }

        }
        return null;
    }
}
