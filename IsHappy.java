package LeetCodeProblem;

public class IsHappy { // 12 -> 5 -> 25
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = digSquare(slow);
            fast = digSquare(digSquare(fast));
            if (fast == 1) {
                return true;
            }
        } while (fast != slow);
        return false;
    }

    public static int digSquare(int n) {
        int square = 0;
        while (n > 0) {
            square += (n % 10) * (n % 10);
            n /= 10;
        }
        return square;
    }
}
