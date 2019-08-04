package leetcode.solution;

import java.util.*;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        int  idx = 0;
        while (idx < nums.length) {
            if (nums[idx] == idx + 1 || nums[idx] == nums[nums[idx] - 1]) {
                idx++;
            } else {
                swap(nums,idx,nums[idx]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] !=  i+ 1) {
                ans.add(i+ 1);
            }
        }
        return ans;
    }
    public void swap(int[] arr,int i,int j)
    {
        arr[i]=arr[i]+arr[j];
        arr[j]=arr[i]-arr[j];
        arr[i]=arr[i]-arr[j];
    }
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
