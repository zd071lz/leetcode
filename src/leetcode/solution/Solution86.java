package leetcode.solution;

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lx = new ListNode(-1);
        ListNode plx = lx;
        ListNode gtx = new ListNode(-1);
        ListNode pgtx = gtx;
        while (head != null) {
            if (head.val < x) {
                plx.next = head;
                plx = plx.next;
            } else {
                pgtx.next = head;
                pgtx = pgtx.next;
            }
            head = head.next;
        }
        pgtx.next = null;
        plx.next = gtx.next;
        return lx.next;
    }
}
