package LeetCodeProblem;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        // calculating length of LInkedList
        int lengthOfList = 0;
        ListNode temp = head;
        while (temp != null) {
            lengthOfList++;
            temp = temp.next;
        }
        // if we have to remove first node
        if (n == lengthOfList) {
            return head.next;
        }
        // to remove every other node except first one.
        temp = head;
        for (int i = 1; i < lengthOfList - n; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
}
