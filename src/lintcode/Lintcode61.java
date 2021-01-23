package lintcode;

/**
 * 61. 搜索区间
 * 中文English
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 *
 * 如果目标值不在数组中，则返回[-1, -1]
 *
 * 样例
 * 例1:
 *
 * 输入:
 * []
 * 9
 * 输出:
 * [-1,-1]
 *
 * 例2:
 *
 * 输入:
 * [5, 7, 7, 8, 8, 10]
 * 8
 * 输出:
 * [3, 4]
 * 挑战
 * 时间复杂度 O(log n)
 */
public class Lintcode61 {
    public int[] searchRange(int[] A, int target) {
        int l = 0;
        int h = A.length - 1;
        while (l <= h) {
            int m = (l + h) >> 1;
            if (target < A[m]) {
                h = m - 1;
            } else if (target > A[m]) {
                l = m + 1;
            } else {
                int start = m;
                while (start > 0 && A[start] == A[start - 1]) {
                    start--;
                }
                int end = m;
                while (end < A.length - 1 && A[end] == A[end + 1]) {
                    end++;
                }
                return new int[]{start, end};
            }
        }
        return new int[]{-1, -1};
    }
}
