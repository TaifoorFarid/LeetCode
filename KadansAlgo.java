package LeetCodeProblem;



public class KadansAlgo {

    public static void main(String[] args) {
        int[] arr = {-100, -99, -50, 10, -2, 10};
        System.out.println(maxSumSubArray(arr));
    }
    public static int maxSumSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
