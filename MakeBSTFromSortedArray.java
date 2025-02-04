package LeetCodeProblem;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class MakeBSTFromSortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums);
    }

    private TreeNode makeBST(int[] nums) {
        return makeBST(nums, 0, nums.length - 1);
    }

    private TreeNode makeBST(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }

        int mid = s + (e - s) / 2;

        TreeNode current = new TreeNode(nums[mid]);
        current.left = makeBST(nums, s, mid - 1);
        current.right = makeBST(nums, mid + 1, e);

        return current;
    }
}