import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxin
 * @create 2021-10-20 10:51
 */


//给定一个二叉树的根节点 root ，返回它的 中序 遍历。

public class test_94 {
    public static void main(String[] args) {

    }
}

class Solution53 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }

            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
