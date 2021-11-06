import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenxin
 * @create 2021-10-26 11:20
 */


//给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
//
//        叶子节点 是指没有子节点的节点。


public class test_112 {
    public static void main(String[] args) {

    }
}

class Solution66 {
//    广度优先搜索-------------------------------------------------------
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//        Queue<TreeNode> queNode = new LinkedList<>();
//        Queue<Integer> queVal = new LinkedList<>();
//        queNode.offer(root);
//        queVal.offer(root.val);
//        while (!queNode.isEmpty()) {
//            TreeNode now = queNode.poll();
//            int temp = queVal.poll();
//            if (now.right == null & now.left == null) {
//                if (temp == targetSum) {
//                    return true;
//                }
//                continue;
//
//            }
//            if (now.left != null) {
//                queNode.offer(now.left);
//                queVal.offer(now.left.val + temp);
//            }
//            if (now.right != null) {
//                queNode.offer(now.right);
//                queVal.offer(now.right.val + temp);
//            }
//        }
//        return false;
//    }

    //递归-------------------------------------------------------------
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
