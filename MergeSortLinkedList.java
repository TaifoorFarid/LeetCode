package LeetCodeProblem;

public class MergeSortLinkedList {
    Node start;
    Node end;
    public Node mergeTwoLists(Node list1, Node list2) {
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                Node node = new Node(list1.val);
                add(node);
                list1 = list1.next;
            } else {
                Node node = new Node(list2.val);
                add(node);
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            Node node = new Node(list1.val);
            add(node);
            list1 = list1.next;
        }

        while (list2 != null) {
            Node node = new Node(list2.val);
            add(node);
            list2 = list2.next;
        }
        return start;
    }

    private void add(Node node) {
        if (start == null) {
            start = node;
            end = node;
        } else {
            end.next = node;
            end = node;
        }
    }

    //-------Merge sort in LinkedList-------------------------------------------
    public Node mergeSort(Node head) {
        if (head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);

        return mergeTwoLists(left, right);
    }

    //-------Method to get middle of list--------------------------------------
    private Node getMid(Node head) {
        Node midPre = null;

        while (head != null && head.next != null) {
            midPre = (midPre == null) ? head : midPre.next;
            head = head.next.next;
        }
        Node mid = midPre.next;
        midPre = null;
        return mid;
    }
}
