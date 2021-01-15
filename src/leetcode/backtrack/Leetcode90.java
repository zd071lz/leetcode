package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0);
        return ans;
    }

    private List<List<Integer>> ans = new LinkedList<>();
    private List<Integer> tmp = new LinkedList<>();

    public void helper(int[] nums, int s) {
        ans.add(new ArrayList<>(tmp));
        for (int i = s; i < nums.length; i++) {
            if (i > s && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            helper(nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
