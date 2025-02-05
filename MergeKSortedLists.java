package LeetCodeProblem;

import java.util.List;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int s, int e) {
        if (s == e) {
            return lists[s];
        }

        int mid = (s + e) / 2;

        ListNode list1 = mergeLists(lists, s, mid);
        ListNode list2 = mergeLists(lists, mid + 1, e);

        return merge(list1, list2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode();
        ListNode start = dummyNode;

        ListNode temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp = l1.next;
                dummyNode.next = l1;
                l1 = temp;
            } else {
                temp = l2.next;
                dummyNode.next = l2;
                l2 = temp;
            }
            dummyNode = dummyNode.next;
        }
        dummyNode.next = (l1 == null) ? l2 : l1;
        return start.next;
    }
}
