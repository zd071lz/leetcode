package leetcode.solution;

public class Solution67 {
    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        StringBuffer sb = new StringBuffer();
        int al = ac.length-1;
        int bl = bc.length-1;
        int x = 0;
        while (al >= 0 || bl >= 0 || x > 0) {
            int ai = al >= 0 ? ac[al--] - '0' : 0;
            int bi = bl >= 0 ? bc[bl--] - '0' : 0;
            int s = ai + bi + x;
            sb.insert(0, s % 2);
            x = s / 2;
        }
        return sb.toString();
    }
}
