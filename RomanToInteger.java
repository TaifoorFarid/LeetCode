package LeetCodeProblem;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
    public static int romanToInt(String s) {
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (takeTwo(s, i)) {
                number += makeInt("" + s.charAt(i) + s.charAt(i + 1));
                i++;
            } else {
                number += makeInt("" + s.charAt(i));
            }
        }
        return number;
    }

    //I can be placed before V (5) and X (10) to make 4 and 9.
    //X can be placed before L (50) and C (100) to make 40 and 90.
    //C can be placed before D (500) and M (1000) to make 400 and 900.
    private static boolean takeTwo(String s, int i) {
        String val;
        if (i < s.length() - 1) {
            val = "" + s.charAt(i) + s.charAt(i + 1);
            return switch (val) {
                case "IV" -> true;
                case "IX" -> true;
                case "XL" -> true;
                case "XC" -> true;
                case "CD" -> true;
                case "CM" -> true;
                default -> false;
            };
        }
        return false;
    }

//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
    public static int makeInt(String n) {
        return switch (n) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            case "D" -> 500;
            case "M" -> 1000;
            case "IV" -> 4;
            case "IX" -> 9;
            case "XL" -> 40;
            case "XC" -> 90;
            case "CD" -> 400;
            case "CM" -> 900;
            default -> 0;
        };
    }
}
