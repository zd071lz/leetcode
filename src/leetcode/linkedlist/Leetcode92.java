package leetcode.linkedlist;

import leetcode.solution.ListNode;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode ret = new ListNode(-1);
        ret.next = head;
        int i = 1;
        ListNode preM = ret;
        while (head.next != null) {
            if (i == m) {
                break;
            }
            preM = head;
            head = head.next;
            i++;
        }
        ListNode preN = head;

        ListNode c = null;
        while (head != null) {
            if (i > n) {
                break;
            }
            ListNode tmp = head.next;
            head.next = c;
            c = head;
            head = tmp;
            i++;
        }
        preM.next = c;
        preN.next = head;

        return ret.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
        reverseBetween(n1, 1, 2);
    }
}
