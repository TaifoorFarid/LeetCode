import java.util.Stack;

public class MinRemovelOFBracket1249 {

    public static void main(String[] args) {
        MinRemovelOFBracket1249 m = new MinRemovelOFBracket1249();
        System.out.println(m.minRemoveToMakeValid("))(("));
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                if (st.isEmpty())
                    sb.setCharAt(i, '1');
                else
                    st.pop();
            }
        }

        while (!st.isEmpty()) {
            sb.setCharAt(st.pop(), '*');
        }

        return sb.toString().replaceAll("1", "");
    }
}
