public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int end = findEndOFLastWord(s);
        if (end == -1)
            return 0;
        int start = findStartOFLastWord(s, end);

        return end - start;
    }

    public int findEndOFLastWord(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                return i;
            }
        }
        return -1;
    }

    public int findStartOFLastWord(String s, int e) {
        for (int i = e - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return i;
            }
        }
        return -1;
    }
}
