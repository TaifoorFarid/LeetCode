public class ClimbStairs {
    public int climbStairs(int n) {
        int[] steps = new int[46];
        return climbStairs(n, steps);
    }

    private int climbStairs(int n, int[] stp) {
        if (stp[n] != 0)
            return stp[n];
        if (n <= 2)
            return n;

        stp[n] = climbStairs(n - 1, stp) + climbStairs(n - 2, stp);
        return stp[n];
    }
}