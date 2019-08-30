package leetcode.solution;

public class Solution707 {
}
class MyLinkedList {
    private int size = 0;
    private MyNode head;
    private MyNode tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = new MyNode();
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        MyNode target = findNode(index);
        return target.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        appendNode(head, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            addAtHead(val);
            return;
        }
        MyNode find = findNode(index - 1);
        appendNode(find, val);
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        MyNode tarPre = findNode(index - 1);
        tarPre.next = tarPre.next.next;
        size--;
    }
    public MyNode findNode(int index) {
        MyNode target = head;
        for (int i = 0; i <= index; i++) {
            target = target.next;
        }
        return target;
    }
    public void appendNode(MyNode n, int val) {
        MyNode tmp = n.next;
        n.next = new MyNode(val);
        n.next.next = tmp;
        size++;
    }
}
class MyNode{
    MyNode() {
    }
    MyNode(int val) {
        this.val = val;
    }
    int val;
    MyNode next;
}