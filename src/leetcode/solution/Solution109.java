package leetcode.solution;

/**
 * @author okr
 */
public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        int size = this.findSize(head);

        this.head = head;

        // Form the BST now that we know the size
        return convertListToBST(0, size - 1);

    }
    private ListNode head;

    private int findSize(ListNode head) {
        ListNode ptr = head;
        int c = 0;
        while (ptr != null) {
            ptr = ptr.next;
            c += 1;
        }
        return c;
    }

    private TreeNode convertListToBST(int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = (l + r) / 2;

        TreeNode left = this.convertListToBST(l, mid - 1);

        TreeNode node = new TreeNode(this.head.val);
        node.left = left;

        this.head = this.head.next;

        node.right = this.convertListToBST(mid + 1, r);
        return node;
    }

}

