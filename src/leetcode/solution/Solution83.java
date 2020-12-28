package leetcode.solution;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pos = head;
        while (pos != null && pos.next != null) {
            if (pos.val == pos.next.val) {
                pos.next = pos.next.next;
            } else {
                pos = pos.next;
            }
        }
        return head;
    }
}
