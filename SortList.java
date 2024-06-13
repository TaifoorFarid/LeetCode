package LeetCodeProblem;

public class SortList {
    public static void main(String[] args) { // -1,5,3,4,0
//        ListNode n1 = new ListNode(-1);
//        ListNode n2 = new ListNode(5);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(0);
//
        Node start = null;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;

        SortList s = new SortList();
        Node ans = s.sortList(start);

        while (ans != null) {
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }
        System.out.println(" Null ");
    }
    private Node mergeTwoLists(Node list1, Node list2) {
        Node dummyHead = new Node();
        Node tail = dummyHead;

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

    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);

        return mergeTwoLists(left, right);
    }

    private Node getMid(Node head) {
        Node midPre = null;

        while (head != null && head.next != null) {
            midPre = (midPre == null) ? head : midPre.next;
            head = head.next.next;
        }
        Node mid = midPre.next;
        midPre.next = null;
        return mid;
    }
}
