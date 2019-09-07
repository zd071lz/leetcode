package leetcode.solution;

import java.util.Arrays;

public class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int m = houses.length, n = heaters.length;
        int i = 0, j = 0, r = 0, ans = 0;
        while (i < m && j < n) {
            if (houses[i] <= heaters[j]) {
                r = heaters[j] - houses[i];
                i++;
            } else if (j < n - 1) {
                r = Math.min(heaters[j + 1] - houses[i], houses[i] - heaters[j]);
                if (houses[i] < heaters[j + 1]) {
                    i++;
                } else {
                    j++;
                }
            } else {
                r = houses[i] - heaters[j];
                i++;
            }
            ans = Math.max(ans, r);
        }
        return ans;
    }
}

