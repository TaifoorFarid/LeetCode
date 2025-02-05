package LeetCodeProblem;

import java.util.List;

public class RotateLIst {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }

        ListNode slNode = head;

        for (int i = k; i > 0 ; i--) {
            while (slNode.next.next != null) {
                slNode = slNode.next;
            }

            ListNode temp = slNode.next;
            slNode.next = null;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
