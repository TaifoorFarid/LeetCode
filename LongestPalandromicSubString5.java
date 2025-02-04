import java.util.HashMap;

public class LongestPalandromicSubString5 {// passed
    public String longestPalindrome(String s) {// babad
        String longestPS = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = checkPalandrome(s, i, i);
            String even = checkPalandrome(s, i, i + 1);

            longestPS = longestPS.length() < odd.length() ? odd : longestPS;
            longestPS = longestPS.length() < even.length() ? even : longestPS;
        }
        return longestPS;
    }

    private String checkPalandrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
