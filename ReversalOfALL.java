package LeetCodeProblem;

public class ReversalOfALL {
    private Node start;
    private Node tail;
    public void reverse(Node node) {
        if (node == null || node.next == null) {
            start = node;
            tail = node;
            return;
        }

        reverse(node.next);
        node.next = null;
        tail.next = node;
        tail = tail.next;
    }

    public static void main(String[] args) {
        Node n1 = new Node(5);
        Node n2 = new Node(4);
        Node n3 = new Node(3);
        Node n4 = new Node(2);
        Node n5 = new Node(1);

        ReversalOfALL r = new ReversalOfALL();
        r.start = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        r.tail = n5;

        Node temp = r.start;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");

        r.reverse(r.start);

        while (r.start != null) {
            System.out.print(r.start.val + " -> ");
            r.start = r.start.next;
        }
        System.out.println("Null");
    }
}
