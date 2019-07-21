package leetcode.solution;

public class Solution1089 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = 0, j = 0;
        while (j < n) {
            if (arr[i] == 0) ++j;
            ++i;
            ++j;
        }
        --i;
        --j;
        while (i >= 0) {
            if (j < n) arr[j] = arr[i];
            if (arr[i] == 0) arr[--j] = arr[i];
            --i;
            --j;
        }
    }
}
