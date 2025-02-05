import java.util.Arrays;

public class ZigZagConverstaion {

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == numRows) {
            return s;
        }
        char[][] zigZag = new char[numRows][s.length() / 2];
        fillArray(zigZag, s);
        return makeString(zigZag);
    }

    public void fillArray(char[][] zig, String s) {
        int row = 0;
        int col = 0;
        int numRows = zig.length - 1;
        boolean toogle = true;
        for (int i = 0; i < s.length(); i++) {
            zig[row][col] = s.charAt(i);
            if (row == numRows)
                toogle = false;

            if (row == 0)
                toogle = true;

            if (toogle) {
                row++;
            } else {
                row--;
                col++;
            }
        }
    }

    private String makeString(char[][] zig) {
        String ans = "";
        for (int i = 0; i < zig.length; i++) {
            for (int j = 0; j < zig[i].length; j++) {
                if (zig[i][j] != '\0') {
                    ans += zig[i][j];
                }
            }
        }
        return ans;
    }
}
