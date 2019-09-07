package leetcode.solution;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums,int left,int right) {
        if (left > right) {
            return null;
        }
        int maxIdx = left;
        for (int i = left+1; i <= right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode n = new TreeNode(nums[maxIdx]);
        n.left = helper(nums, left, maxIdx - 1);
        n.right = helper(nums, maxIdx + 1, right);
        return n;
    }
}
