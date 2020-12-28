package leetcode.linkedlist;

import leetcode.solution.ListNode;

/**
 * 141. 环形链表
 *
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
