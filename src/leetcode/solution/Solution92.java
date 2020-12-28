package leetcode.solution;

/**
 * @author okr
 */
public class Solution92 {
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
