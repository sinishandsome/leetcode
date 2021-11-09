import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @create 2021-11-08 21:12
 */
//
//105. 从前序与中序遍历序列构造二叉树
//        给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
//
//
//
//        示例 1:
//
//
//        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//        Output: [3,9,20,null,null,15,7]
//        示例 2:
//
//        Input: preorder = [-1], inorder = [-1]
//        Output: [-1]
//
//
//        提示:
//
//        1 <= preorder.length <= 3000
//        inorder.length == preorder.length
//        -3000 <= preorder[i], inorder[i] <= 3000
//        preorder 和 inorder 均无重复元素
//        inorder 均出现在 preorder
//        preorder 保证为二叉树的前序遍历序列
//        inorder 保证为二叉树的中序遍历序列


public class test_105 {
    public static void main(String[] args) {

    }
}

class Solution79 {
    private Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_rihgt, int inorder_left, int inorder_right) {

        if (preorder_left > preorder_rihgt) {
            return null;
        }
        int preorder_root = preorder_left;
        int inorder_root = indexMap.get(preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_root]);
        int size_left_subtree = inorder_root - inorder_left;
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_rihgt, inorder_root + 1, inorder_right);
        return root;
    }
}
