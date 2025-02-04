import java.util.Stack;

public class SymmetricTree101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null)
            return true;
        if (l == null || r == null)
            return false;

        return (l.val == r.val) && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }
}