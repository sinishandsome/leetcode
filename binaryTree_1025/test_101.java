/**
 * @author chenxin
 * @create 2021-10-25 11:08
 */
public class test_101 {
    public static void main(String[] args) {

    }
}

class Solution63 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


}
