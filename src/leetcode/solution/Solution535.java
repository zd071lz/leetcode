package leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution535 {
    private Map<Integer, String> map = new HashMap<>();
    private int count = 0;
    public String encode(String longUrl) {
        int id = count++;
        String hexString = Integer.toString(id,36);
        map.put(id, longUrl);
        return "http://tinyurl.com/" + hexString;
    }

    public String decode(String shortUrl) {
        String hexString = shortUrl.substring(19);
        return map.get(Integer.valueOf(hexString,36));
    }

    public static void main(String[] args) {
        System.out.println("http://tinyurl.com/aaa".substring(19));
        String s = Integer.toString(3142,36);
        System.out.println(s);
        System.out.println(Integer.valueOf(s,36));

    }
}
