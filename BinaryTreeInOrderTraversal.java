import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        inorderTraversal(res, root);
        return res;
    }

    private void inorderTraversal(LinkedList<Integer> ans, TreeNode n) {
        if (n == null)
            return;

        inorderTraversal(ans, n.left);
        ans.add(n.val);
        inorderTraversal(ans, n.right);
    }
}
