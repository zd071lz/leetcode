package leetcode.solution;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head == null || head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode ret = new ListNode(-1);
        ret.next = head;

        ListNode pos = ret;
        while (pos != null && pos.next != null) {
            ListNode cur = pos.next;
            while (cur != null && cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pos.next != cur && pos.next.val == cur.val) {
                pos.next = cur.next;
            } else {
                pos = cur;
            }
        }
        return ret.next;
    }
}
