package leetcode.linkedlist;

import leetcode.solution.ListNode;

/**
 * 142. 环形链表 II
 */
public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode oth = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                oth = head;
                break;
            }
        }
        if (oth == null) {
            return null;
        }
        while (oth != slow) {
            oth = oth.next;
            slow = slow.next;
        }
        return oth;
    }
}
