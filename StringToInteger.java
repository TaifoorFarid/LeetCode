import java.math.BigInteger;

public class StringToInteger {

    public static void main(String[] args) {
        int ans = myAtoi("42");
        System.out.println(ans);
    }

    public static int myAtoi(String s) {

        BigInteger num = BigInteger.valueOf(0);
        int i = 0;
        boolean negative = false;

        int ind[] = signOrNumber(s);

        if (ind[0] == 0)
            return num.intValue();

        if (s.charAt(ind[1]) == '-') {
            negative = true;
            i = ind[1] + 1;
        } else if (s.charAt(ind[1]) == '+')
            i = ind[1] + 1;
        else
            i = ind[1];

        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = (num.multiply(new BigInteger("10"))).add(new BigInteger(ch + ""));
            } else {
                break;
            }
        }
        if (num.intValue() > Integer.MAX_VALUE || num.intValue() < Integer.MIN_VALUE) {
            if (negative)
                num = BigInteger.valueOf(Integer.MIN_VALUE);
            else
                num = BigInteger.valueOf(Integer.MAX_VALUE);
        } else if (negative)
            num = num.multiply(new BigInteger("-1"));

        return num.intValue();
    }

    private static int[] signOrNumber(String s) {
        int i;
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ') {
                if (ch == '+' || ch == '-' || (ch >= '0' && ch <= '9')) {
                    return new int[] { 1, i };
                } else {
                    return new int[] { 0, i };
                }
            }
        }
        return new int[] { 0, i - 1 };
    }
}
