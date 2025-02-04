import java.util.Arrays;

public class RangeSumOfSortedArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        rangeSum(arr, 4, 1, 5);
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        final int M = 1_000_000_007;
        int res = 0;
        int[] subArraySum = new int[n * (n + 1) / 2];

        int index = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = (sum + nums[j]) % M;
                subArraySum[index++] = sum;
            }
        }

        Arrays.sort(subArraySum);

        for (int i = left - 1; i < right; i++) {
            res = (res + subArraySum[i]) % M;
        }

        return res;
    }
}