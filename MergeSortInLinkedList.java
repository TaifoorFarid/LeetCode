// https://leetcode.com/problems/sort-list/
// 9 ms Solution (sorting LinkedList using merge sort)

class MergeSortInLinkedList {
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode midPre = null;

        while (head != null && head.next != null) {
            midPre = (midPre == null) ? head : midPre.next;
            head = head.next.next;
        }
        ListNode mid = midPre.next;
        midPre.next = null;
        return mid;
    }

}
