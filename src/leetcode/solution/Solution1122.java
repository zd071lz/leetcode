package leetcode.solution;

public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int a : arr1) {
            count[a]++;
        }
        int t = 0;
        for (int a : arr2) {
            while (count[a] > 0) {
                arr1[t++] = a;
                count[a]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr1[t++] = i;
                count[i]--;
            }
        }
        return arr1;
    }

}
