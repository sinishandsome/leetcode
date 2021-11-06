/**
 * @author chenxin
 * @create 2021-10-26 11:11
 */


//翻转一棵二叉树。
//
//        示例：
//
//        输入：
//
//        4
//        /   \
//        2     7
//        / \   / \
//        1   3 6   9
//        输出：
//
//        4
//        /   \
//        7     2
//        / \   / \
//        9   6 3   1


public class test_226 {
    public static void main(String[] args) {

    }
}
class Solution65 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
