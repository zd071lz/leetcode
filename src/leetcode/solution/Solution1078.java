package leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1078. Bigram 分词
 */
public class Solution1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length - 2; i++) {
            if (first.equals(words[i]) && second.equals(words[i + 1])) {
                ans.add(words[i + 2]);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
