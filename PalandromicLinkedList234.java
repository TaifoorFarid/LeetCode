import java.util.Stack;

public class PalandromicLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        Stack<Integer> st = new Stack<>();
        ListNode fast = head;

        while (true) {
            st.push(head.val);
            if (fast == null || fast.next == null) {
                if (st.size() % 2 != 0) {
                    st.pop();
                }
                return check(st, head.next);
            }
            if (fast.next != null)
                fast = fast.next.next;

            head = head.next;

        }
    }

    private boolean check(Stack<Integer> st, ListNode head) {
        while (head != null) {
            if (head.val != st.pop()) {
                return false;
            }
            head = head.next;
        }

        return st.isEmpty();
    }
}
