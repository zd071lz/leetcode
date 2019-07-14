package leetcode.solution;

public class Solution1103 {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int x = 1, pos = 0;
        while (candies > 0) {
            pos = (x - 1) % num_people;
            if (x > candies) {
                x = candies;
            }
            ans[pos] += x;
            candies -= x;
            x++;
        }
        return ans;
    }
}
