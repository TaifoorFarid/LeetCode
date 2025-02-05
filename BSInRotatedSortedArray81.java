public class BSInRotatedSortedArray81 {
    public boolean search(int[] nums, int target) {
        return BS(nums, 0, nums.length - 1, target);
    }

    private boolean BS(int[] nums, int s, int e, int target) {
        if (s > e) {
            return false;
        }

        int mid = s + (e - s) / 2;

        if (target == nums[mid])
            return true;

        if (nums[s] == nums[mid] && nums[e] == nums[mid]) { // for duplicates
            return BS(nums, s, mid - 1, target) || BS(nums, mid + 1, e, target);
        }

        if (nums[e] >= nums[mid]) {
            if (target > nums[mid] && target <= nums[e])
                return BS(nums, mid + 1, e, target);
            else
                return BS(nums, s, mid - 1, target);
        } else {
            if (target >= nums[s] && target < nums[mid])
                return BS(nums, s, mid - 1, target);
            else
                return BS(nums, mid + 1, e, target);
        }
    }
}