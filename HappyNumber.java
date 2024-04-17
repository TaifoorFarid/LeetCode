// https://leetcode.com/problems/happy-number/submissions/1235022431/
// 0 ms
class HappyNumber {
    public boolean isHappy(int n) {
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

    public int digSquare(int n) {
        int square = 0;
        while (n > 0) {
            square += (n % 10) * (n % 10);
            n /= 10;
        }
        return square;
    }
}
