// package LeetCodeProblem;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 1 || strs[0].isEmpty())
            return strs[0];
        String prefix = "";
        String finalPrefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            prefix += strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (!cmp(prefix, strs[j])) {
                    return finalPrefix;
                }
            }
            finalPrefix = prefix;
        }
        return finalPrefix;
    }

    private boolean cmp(String prefix, String cmpWith) {
        if (prefix.length() > cmpWith.length()) {
            return false;
        }
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != cmpWith.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
// ||