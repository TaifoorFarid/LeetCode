public class Sqrt69 {
    public int mySqrt(int x) {
        return sqrt(x);
    }

    private int sqrt(int n) {
        double s = 0;
        double e = n;
        double mid = 0;

        while (s < e) {
            mid = s + (e - s) / 2;
            if ((long) (mid * mid) == n) {
                break;
            } else if (mid * mid > n) {
                e = mid;
            } else {
                s = mid;
            }
        }

        return (int) mid;
    }
}