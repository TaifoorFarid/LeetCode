import java.util.HashMap;

public class LongestPalandromicSubString {// solved Using Dynamic programming approach

    // public static void main(String[] args) {

    // LongestPalandromicSubString l = new LongestPalandromicSubString();
    // System.out.println(l.longestPalindrome(
    // "jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcowskjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsmlsuacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakzconeuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgwfqmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvlsyomkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdcoegamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnvlbtixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcepbmuwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlbxzcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanilsyyklpbxqosoquolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwzirsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfytfabx"));
    // }

    public String longestPalindrome(String s) {
        HashMap<String, String> memo = new HashMap<>();
        return LPS(s, memo);
    }

    private String LPS(String s, HashMap<String, String> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.length() == 1) {
            return s;
        }

        if (isPalandrome(s)) {
            memo.put(s, s);
            return s;
        }

        String left = LPS(s.substring(0, s.length() - 1), memo);
        String right = LPS(s.substring(1, s.length()), memo);
        memo.put(s, (left.length() > right.length()) ? left : right);
        return memo.get(s);
    }

    private boolean isPalandrome(String str) {
        int s = 0;
        int e = str.length() - 1;

        while (s < e) {
            if (str.charAt(s++) != str.charAt(e--))
                return false;
        }
        return true;
    }
}
