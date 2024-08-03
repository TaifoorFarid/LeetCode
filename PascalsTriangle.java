package LeetCodeProblem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> segment = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                segment.add(binomialCoefficient(row, col).intValue());
            }
            ans.add(segment);
        }
        return ans;
    }

    private BigInteger binomialCoefficient(int n, int k) {
        return factorial(n).divide(factorial(k).multiply(factorial(n - k)));
    }

    private BigInteger factorial(int n) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
