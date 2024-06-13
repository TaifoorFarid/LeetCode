package LeetCodeProblem;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        System.out.println("23" + 6);
    }
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode preMid = head;

        while (preMid.next != mid) {
            preMid = preMid.next;
        }

        preMid.next = null;
        mid = reverse(mid);
        ListNode fHalf = head;
        ListNode sHalf = mid;

        while (fHalf != null && sHalf != null) {
            if (fHalf.val != sHalf.val) {
                break;
            }
            fHalf = fHalf.next;
            sHalf = sHalf.next;
        }

        preMid.next = reverse(mid);

        return fHalf == null || sHalf == null;
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
