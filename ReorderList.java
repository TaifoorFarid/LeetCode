package LeetCodeProblem;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        ListNode newList = findMid(head);

        newList = reverse(newList);

        ListNode hf = head;
        ListNode hs = newList;

        while (hf.next != null && hs.next != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
    }

    private ListNode reverse(ListNode start) {
        if (start == null || start.next == null) {
            return start;
        }

        ListNode now = start;
        ListNode next = start.next;
        start = null;

        while (now != null) {
            now.next = start;
            start = now;
            now = next;

            if (next != null) {
                next = next.next;
            }
        }

        return start;
    }

    private ListNode findMid(ListNode start) {
        if (start == null || start.next == null) {
            return start;
        }

        ListNode slow = start;
        ListNode fast = start;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
