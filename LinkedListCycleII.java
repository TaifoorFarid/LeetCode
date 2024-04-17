/// https://leetcode.com/problems/linked-list-cycle-ii/description/
// solved with 0ms
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        int cycleLen = cycleSize(head);
        if (cycleLen == 0) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (cycleLen > 0) {
            first = first.next;
            cycleLen--;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public int cycleSize(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                int count = 0;
                do {
                    slow = slow.next;
                    count++;
                } while (fast != slow);
                return count;
            }
        }
        return 0;
    }
}
