package LeetCodeProblem;

public class LinkedListCycleII {
    public Node detectCycle(Node head) {
        int cycleLen = cycleSize(head);
        if (cycleLen == 0) {
            return null;
        }
        Node first = head;
        Node second = head;
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

    public int cycleSize(Node head) {
        Node slow = head;
        Node fast = head;

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
