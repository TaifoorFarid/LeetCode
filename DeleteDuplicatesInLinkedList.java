// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class DeleteDuplicatesInLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
