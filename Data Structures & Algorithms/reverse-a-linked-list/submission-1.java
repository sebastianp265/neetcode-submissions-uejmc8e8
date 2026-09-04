
class Solution {

    private ListNode newHead = null;

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        reverseListRecursive(head);

        return newHead;
    }

    void reverseListRecursive(ListNode node) {
        if(node.next == null) {
            newHead = node;
            return;
        }
        reverseListRecursive(node.next);
        node.next.next = node;
        node.next = null;
    }
}