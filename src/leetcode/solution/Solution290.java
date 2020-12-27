package leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        char[] chars = pattern.toCharArray();
        if (split.length != chars.length) {
            return false;
        }
        Map<String, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            Character c = map.get(split[i]);
            if (c == null) {
                map.put(split[i], chars[i]);
                c = chars[i];
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            } else if (!c.equals(chars[i])) {
                return false;
            }
        }
        return true;
    }

}
