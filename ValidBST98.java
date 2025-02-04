import java.util.ArrayList;

public class ValidBST98 {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        isValidBST(root, res);
        int prev = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= prev)
                return false;
            prev = res.get(i);
        }
        return true;
    }

    private void isValidBST(TreeNode n, ArrayList<Integer> res) {
        if (n == null) {
            return;
        }

        isValidBST(n.left, res);
        res.add(n.val);
        isValidBST(n.right, res);
    }
}
