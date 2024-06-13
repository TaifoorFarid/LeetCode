package LeetCodeProblem;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class ReverseSubLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head.next == null) {
            return head;
        }

        ListNode subLLHead = head;
        ListNode leftEdge = null;

        for (int i = 1; i < left; i++) {
            leftEdge =  subLLHead;
            subLLHead = subLLHead.next;
        }

        if (leftEdge != null) {
            leftEdge.next = null;
        }

        ListNode tailOfSubLL = subLLHead;
        ListNode rightEdge = null;

        for (int i = 1; i <= right - left; i++) {
            tailOfSubLL = tailOfSubLL.next;
        }

        if (tailOfSubLL.next != null) {
            rightEdge = tailOfSubLL.next;
        }

        tailOfSubLL.next = null;


        reverse(subLLHead);

        if (leftEdge != null) {
            leftEdge.next = tailOfSubLL;
        }

        subLLHead.next = rightEdge;

        return head;
    }

    private void reverse(ListNode start) {
        if (start == null || start.next == null) {
            return;
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
    }
}
