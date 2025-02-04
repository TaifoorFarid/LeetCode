public class ValidPalandrome125 {// Works in 6ms

    public boolean isPalindrome(String s) {
        String modifiedString = trim(s);
        return isValidPlan(modifiedString);
    }

    private String trim(String s) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (inRange(ch)) {
                res.append((ch >= 65 && ch <= 90) ? (char) (ch + 32) + "" : (char) ch + "");
            }
        }
        return res.toString();
    }

    private boolean inRange(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57);
    }

    private boolean isValidPlan(String str) {
        int s = 0;
        int e = str.length() - 1;

        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}

class AnotherSolution {// Works in 2ms
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !isValid(s.charAt(start))) {
                start++;
            }
            while (start < end && !isValid(s.charAt(end))) {
                end--;
            }
            if (start > end)
                break;
            char st = Character.toLowerCase(s.charAt(start));
            char en = Character.toLowerCase(s.charAt(end));
            if (st != en) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isValid(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57);
    }
}
