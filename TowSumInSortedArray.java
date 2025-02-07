package LeetCodeProblem;

public class TowSumInSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int second = numbers.length - 1;
        int[] res = {-1, -1};

        while (first < second) {
            int sum = numbers[first] + numbers[second];
            if (sum == target) {
                return new int[]{first + 1, second + 1};
            } else if (sum < target) {
                first++;
            } else {
                second++;
            }
        }
        return res;
    }
}
