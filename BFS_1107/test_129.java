import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenxin
 * @create 2021-11-07 9:47
 */


//129. 求根节点到叶节点数字之和
//        给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
//        每条从根节点到叶节点的路径都代表一个数字：
//
//        例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
//        计算从根节点到叶节点生成的 所有数字之和 。
//
//        叶节点 是指没有子节点的节点。

public class test_129 {
    public static void main(String[] args) {

    }
}

class Solution78 {

    //广度优先搜索
    public int sumNumbers(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        queue.offer(root);
        numQueue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int num = numQueue.poll();
            if (node.left == null && node.right == null) {
                ans += num;
            }
            if (node.left != null) {
                queue.offer(node.left);
                numQueue.offer(num * 10 + node.left.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                numQueue.offer(num * 10 + node.right.val);
            }
        }
        return ans;
    }

    //深度优先搜索
//    public int sumNumbers(TreeNode root) {
//        return dfs(root, 0);
//    }
//
//    public int dfs(TreeNode root, int prevSum) {
//        if (root == null) {
//            return 0;
//        }
//        int sum = prevSum * 10 + root.val;
//        if (root.left == null && root.right == null) {
//            return sum;
//        } else {
//            return dfs(root.left, sum) + dfs(root.right, sum);
//        }
//
//    }
}
