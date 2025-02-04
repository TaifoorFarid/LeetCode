public class MaximumDeepthOfBT104 {
    public int maxDepth(TreeNode root) {
        return deepth(root);
    }

    private int deepth(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return Math.max(deepth(n.left), deepth(n.right)) + 1;
    }
}