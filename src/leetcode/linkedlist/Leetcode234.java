package leetcode.linkedlist;

import leetcode.solution.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *      输入: 1->2
 *      输出: false
 * 示例 2:
 *
 *      输入: 1->2->2->1
 *      输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return helper(head);
    }

    ListNode frontPointer;

    public boolean helper(ListNode currentNode) {
        if (currentNode != null) {
            if (!helper(currentNode.next)) {
                return false;
            }
            if (frontPointer.val != currentNode.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
