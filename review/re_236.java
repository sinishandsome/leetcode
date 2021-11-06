/**
 * @author chenxin
 * @create 2021-11-04 18:59
 */
public class re_236 {
    public static void main(String[] args) {

    }
}

class Solution_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (right == null) {
            return left;
        }
        if (left == null) {
            return right;
        }
        return root;
    }
}
