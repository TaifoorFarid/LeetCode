class AddBinaryStrings {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        String res = "";
        int carry = 0;

        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                if (carry == 1)
                    res = "1" + res;
                else
                    res = "0" + res;
                carry = 1;
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                if (carry == 1)
                    res = "1" + res;
                else
                    res = "0" + res;
                carry = 0;
            } else {
                if (carry == 1) {
                    res = "0" + res;
                    carry = 1;
                } else {
                    res = "1" + res;
                    carry = 0;
                }
            }
            i--;
            j--;
        }
        if (carry == 1 && (i < 0 && j < 0)) {
            return "1" + res;
        }

        if (j >= 0)
            res = compAdd(carry, b, j) + res;

        if (i >= 0)
            res = compAdd(carry, a, i) + res;
        return res;
    }

    private String compAdd(int carry, String str, int ind) {
        String ans = "";
        for (int i = ind; i >= 0; i--) {
            if (carry == 1 && str.charAt(i) == '1') {
                ans = "0" + ans;
            } else {
                if (carry == 1) {
                    ans = "1" + ans;
                    carry = 0;
                } else {
                    ans = str.charAt(i) + ans;
                    carry = 0;
                }
            }
        }
        if (carry == 1)
            return "1" + ans;
        return ans;
    }
}