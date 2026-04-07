



class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var head = new ListNode();
        var tail = head;
        while(list1 != null && list2 != null) {
            ListNode newTail;
            if(list1.val < list2.val) {
                newTail = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                newTail = new ListNode(list2.val);
                list2 = list2.next;
            }
            tail.next = newTail;
            tail = newTail;
        }

        tail.next = list1 == null ? list2 : list1;

        return head.next;
    }
}