import java.util.ArrayList;

public class PhoneDigitCom {
    ArrayList<String> ans = new ArrayList<>();

    public ArrayList<String> combonations(String num) {
        findCom(num, "");
        return ans;
    }

    private void findCom(String num, String part) {
        if (num.isEmpty()) {
            ans.add(part);
            return;
        }

        String chars = getChars(Integer.parseInt(num.charAt(0) + ""));
        for (int j = 0; j < chars.length(); j++) {
            findCom(num.substring(1), part + chars.charAt(j));
        }

    }

    private String getChars(int num) {
        switch (num) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                return null;
        }
    }

}
