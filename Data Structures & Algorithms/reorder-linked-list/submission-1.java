class Solution {
    public void reorderList(ListNode firstPart) {
        var n = countElements(firstPart);
        ListNode lastElementOfFirstPart = firstPart;
        for (int i = 1; i < n / 2 + n % 2; i++) {
            lastElementOfFirstPart = lastElementOfFirstPart.next;
        }
        var secondPart = lastElementOfFirstPart.next;
        lastElementOfFirstPart.next = null;
        secondPart = reverseList(secondPart);

        while(secondPart != null) {
            var firstPartNext = firstPart.next;
            var secondPartNext = secondPart.next;

            firstPart.next = secondPart;
            secondPart.next = firstPartNext;

            secondPart = secondPartNext;
            firstPart = firstPartNext;
        }

    }

    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        var current = head;
        while (current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private int countElements(ListNode listNode) {
        int i = 0;
        while (listNode != null) {
            i++;
            listNode = listNode.next;
        }
        return i;
    }

}