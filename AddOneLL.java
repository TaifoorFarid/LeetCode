package LeetCodeProblem;

public class AddOneLL {
    static class Node {
        int data;
        Node next;
        public Node(int val) {
            this.data = val;
        }
    }

    public static void main(String[] args) {

        String str = "عَ";
        System.out.println(str.length());
        System.out.println(str.charAt(0));
        System.out.println(str.charAt(1));
    }

    public static Node addOne(Node n) {
        n = reverse(n);
        Node temp = n;
        Node last = null;
        boolean isNine = true;
        while (temp != null) {
            if (temp.data < 9) {
                temp.data += 1;
                isNine = false;
                break;
            } else {
                temp.data = 0;
            }
            last = temp;
            temp = temp.next;
        }
        if (isNine && last != null) {
            last.next = new Node(1);
        }
        return reverse(n);
    }

    private static Node reverse(Node n) {
        Node revList = null;
        while (n != null) {
            revList = insertAtStart(n.data, revList);
            n = n.next;
        }
        return revList;
    }

    private static Node insertAtStart(int val, Node n) {
        if (n == null) {
            return new Node(val);

        } else {
            Node node = new Node(val);
            node.next = n;
            return node;
        }
    }
}
