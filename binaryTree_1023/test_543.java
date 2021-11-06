/**
 * @author chenxin
 * @create 2021-10-23 16:45
 */

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
//        示例 :
//        给定二叉树
//
//        1
//        / \
//        2   3
//        / \
//        4   5
//        返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
//
//
//
//        注意：两结点之间的路径长度是以它们之间边的数目表示。


public class test_543 {
    public static void main(String[] args) {

    }
}

class Solution59 {
    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return maxD;
    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        maxD = Math.max(left + right, maxD);
        return Math.max(left, right) + 1;   //返回当前子树最大深度
    }
}
