package LeetCodeProblem;

import java.util.List;

public class ReverseNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode n1 = head;
        ListNode n2 = head.next;
        while (n1 != null && n2 != null) {
            int swap = n1.val;
            n1.val = n2.val;
            n2.val = swap;

            if (n1.next != null) {
                n1 = n1.next.next;
            }

            if (n2.next != null) {
                n2 = n2.next.next;
            }
        }
        return head;
    }
}
