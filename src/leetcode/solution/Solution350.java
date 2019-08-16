package leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int t1 = 0, t2 = 0;
        List<Integer> list = new LinkedList<>();
        while (t1 < nums1.length && t2 < nums2.length) {
            if (nums1[t1] == nums2[t2]) {
                list.add(nums1[t1]);
                t1++;
                t2++;
            }else if (nums1[t1] < nums2[t2]) {
                t1++;
            }else if (nums1[t1] > nums2[t2]) {
                t2++;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
