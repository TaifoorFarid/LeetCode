public class IntersectionOfTwoLL160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        if (lenA > lenB) {
            headA = moveForward(lenA - lenB, headA);
        } else {
            headB = moveForward(lenB - lenA, headB);
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private ListNode moveForward(int move, ListNode node) {
        for (int i = 0; i < move; i++) {
            node = node.next;
        }
        return node;
    }

    private int getLength(ListNode head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }
}
