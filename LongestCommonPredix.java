package LeetCodeProblem;

public class LongestCommonPredix {

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs[0].isEmpty()) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            prefix += strs[0].charAt(i);
            if (!checkPrefix(strs, prefix)) {
                return prefix.substring(0, i);
            }
        }
        return prefix;
    }

    private static boolean checkPrefix(String[] strings, String prefix) {
        for (String str : strings) {
            for (int j = 0; j < prefix.length(); j++) {
                if (prefix.length() <= str.length()) {
                    return true;
                }
                if (str.charAt(j) != prefix.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
