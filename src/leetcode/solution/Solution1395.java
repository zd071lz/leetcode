package leetcode.solution;

/**
 * 1395. 统计作战单位数
 */
public class Solution1395 {
    public int numTeams(int[] rating) {
        int ans = 0;
        for (int j = 1; j < rating.length - 1; j++) {
            int leftAsc = 0;
            int leftDesc = 0;
            for (int i = j - 1; i >= 0; i--) {
                if (rating[i] < rating[j]) {
                    leftAsc++;
                } else if (rating[i] > rating[j]) {
                    leftDesc++;
                }
            }
            int rightAsc = 0;
            int rightDesc = 0;
            for (int k = j + 1; k < rating.length; k++) {
                if (rating[j] < rating[k]) {
                    rightAsc++;
                } else if (rating[j] > rating[k]) {
                    rightDesc++;
                }
            }
            ans += leftAsc * rightAsc + leftDesc * rightDesc;
        }
        return ans;
    }
}
