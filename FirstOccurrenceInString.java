package LeetCodeProblem;

public class FirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        for (int i = 0; i < n; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if(checkFullOcc(haystack, needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean checkFullOcc(String haystack, String needle, int i) {
        for (int j = 0; j < needle.length(); j++) {
            if ((i + j) >= haystack.length() || (haystack.charAt(i + j) != needle.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
