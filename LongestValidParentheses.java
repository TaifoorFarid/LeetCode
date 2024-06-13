package LeetCodeProblem;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("( ()"));
    }
    public static int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Stack<Character> st = new Stack<>();

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (st.empty() || st.peek() == '(') {
                    st.push('(');
                }
//                else if (st.peek() == ')') {
//                    while (st.empty())
//                        st.pop();
//                    maxCount = Math.max(count, maxCount);
//                    count = 0;
//                    st.push('(');
//                }
            } else if (s.charAt(i) == ')') {
                if (st.peek() == '(') {
                    st.pop();
                    count += 2;
                } else {
                    maxCount = Math.max(count, maxCount);
                    count = 0;
                }
            }
        }
        return Math.max(count, maxCount);
    }
}
