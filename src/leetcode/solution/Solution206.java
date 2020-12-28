package leetcode.solution;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        //TODO 递归
        return null;
    }
    public ListNode reverseList1(ListNode head) {
        ListNode c = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = c;
            c = head;
            head = tmp;
        }
        return c;
    }
}
