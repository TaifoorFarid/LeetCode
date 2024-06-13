package LeetCodeProblem;

import java.math.BigInteger;
import java.util.Stack;

public class ValidParentheses {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = makeNumber(l1);
        BigInteger num2 = makeNumber(l2);

        BigInteger sum = num1.add(num2);

        return makeList(sum);
    }

    public static ListNode makeList(BigInteger num) {
        if (num.equals(new BigInteger(0 + ""))) {
            return new ListNode(0);
        }
        BigInteger mod = (num.mod(new BigInteger(10 + "")));
        ListNode start = new ListNode(mod.intValue());
        num = num.divide(new BigInteger(10 + ""));
        ListNode temp = start;
        while (num.intValue() > 0) {
            ListNode node = new ListNode();
            mod = (num.mod(new BigInteger(10 + "")));
            node.val = mod.intValue();
            temp.next = node;
            num = num.divide(new BigInteger(10 + ""));
            temp = temp.next;
        }
        return start;
    }

    public static BigInteger makeNumber(ListNode li) {
        BigInteger ans = new BigInteger("0");
        ListNode temp = li;
        BigInteger place = new BigInteger("0");

        while (temp != null) {
            ans = ans.add(place.multiply(new BigInteger(temp.val + "")));
            place = place.multiply(new BigInteger(10 + ""));
            temp = temp.next;
        }
        return ans;
    }

    public static void main(String[] args) {
//        long num1 = returnLong();
//        long num2 = 9;
//        System.out.println(Integer.MAX_VALUE - 9999999991L);
        // 1,9,9,9,9,9,9,9,9,9
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        ListNode n8 = new ListNode(9);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(9);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        BigInteger num1 = makeNumber(n1);
        System.out.println("Number: " + num1);
        BigInteger num2 = makeNumber(new ListNode(9));
        System.out.println("Number: " + num2);
        BigInteger sum = num1.add(num2);
        System.out.println(sum);
        ListNode node =  makeList(sum);
        System.out.print("Output: ");
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
//        System.out.println(makeNumber(n1));
    }//                              2147483647

    private static long returnLong() {
        long num = 9999999991l;
        return num;
    }
    //                               2147483651

    public static int reverse(int x) {
        long ans = 0;
        boolean flag = false;
        if (x < 0) {
            x = x * -1;
            flag = true;
        }

        while (x > 0) {
            ans = ans * 10 + (x % 10);
            x /= 10;
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            ans = 0;
        }

        return flag ? (int)(ans * -1) : (int) ans;
    }
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                switch (ch) {
                    case ')':
                        if (!st.isEmpty() && st.peek() == '(')
                            st.pop();
                        else
                            return false;
                        break;
                    case ']':
                        if (!st.isEmpty() && st.peek() == '[')
                            st.pop();
                        else
                            return false;
                        break;
                    case '}':
                        if (!st.isEmpty() && st.peek() == '{')
                            st.pop();
                        else
                            return false;
                        break;
                }
            }
        }
        return st.isEmpty();
    }
}
