// https://leetcode.com/problems/reverse-linked-list/
// 0 ms Solution
class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        head = null;
        while (temp != null) {
            ListNode node = new ListNode(temp.val);
            node.next = head;
            head = node;
            temp = temp.next;
        }
        return head;
    }
}
