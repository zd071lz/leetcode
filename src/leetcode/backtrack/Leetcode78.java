package leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0);
        return ans;
    }
    private List<List<Integer>> ans = new LinkedList<>();
    private List<Integer> tmp = new LinkedList<>();
    public void helper(int[] nums, int s) {
        ans.add(new ArrayList<>(tmp));
        if (s >= nums.length) {
            return;
        }
        for (int i = s; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
