package leetcode.solution;

/**
 * @author okr
 */
public class Solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cot = new int[101];
        int[] res = new int[nums.length];
        int tol = 0;
        for (int i = 0; i < nums.length; i++) {
            cot[nums[i]]++;
        }
        for (int i = 0; i < cot.length; i++) {
            if(cot[i]>0){
                int tmp = cot[i];
                cot[i] = tol;
                tol += tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = cot[nums[i]];
        }
        return res;
    }

}
