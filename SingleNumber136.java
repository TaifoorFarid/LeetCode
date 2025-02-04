public class SingleNumber136 {
    public static void main(String[] args) {
        System.out.println(10 ^ 0);
    }

    public int singleNumber(int[] nums) {
        for (int i = 1, n = nums.length; i < n; i++) {
            nums[0] ^= nums[i];
        }

        return nums[0];
    }
}