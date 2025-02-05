package LeetCodeProblem;

class Node {
      int val;
      Node next;
      public Node() {}
      public Node(int val) { this.val = val; }
      public Node(int val, Node next) { this.val = val; this.next = next; }
}
//  1 -> 1 -> 1 -> 3 -> 4 -> 4
public class DeleteDuplicatesInLinkedList {
    public Node deleteDuplicates(Node head) {
        Node temp = head;

        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    Node start;
    Node end;
    public Node mergeTwoLists(Node list1, Node list2) {

        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        while (list1 != null || list2 != null) {
            if (list1.val < list2.val) {
                add(list1.val);
                list1 = list1.next;
            } else {
                add(list2.val);
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            add(list2.val);
            list2 = list2.next;
        }
        return start;

    }

    private void add(int val) {
        Node node = new Node(val);
        if (start == null) {
            start = node;
            end = node;
        } else {
            end.next = node;
            end = node;
        }
    }

}
