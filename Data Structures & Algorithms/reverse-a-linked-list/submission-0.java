/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        var tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        reverseListRecursive(head);

        return tail;
    }

    void reverseListRecursive(ListNode node) {
        if(node.next == null) {
            return;
        }
        reverseListRecursive(node.next);
        node.next.next = node;
        node.next = null;
    }
}
