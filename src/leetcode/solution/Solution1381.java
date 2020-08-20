package leetcode.solution;

/**
 * @author okr
 */
public class Solution1381 {

    public Solution1381(int maxSize) {
        stack = new int[maxSize];
        cur = -1;
    }
    private int[] stack;
    private int cur;

    public void push(int x) {
        if (cur + 1 < stack.length) {
            stack[++cur] = x;
        }
    }

    public int pop() {
        if (cur == -1) {
            return -1;
        }
        return stack[cur--];
    }

    public void increment(int k, int val) {
        int min = k < cur + 1 ? k : cur + 1;
        for (int i = 0; i < min; i++) {
            stack[i] += val;
        }
    }
}
