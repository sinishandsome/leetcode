import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenxin
 * @create 2021-10-28 9:22
 */

//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//
//        示例 1:
//
//        输入:[1,2,3,null,5,null,4]
//        输出:[1,3,4]
//        示例 2:
//
//        输入:[1,null,3]
//        输出:[1,3]
//        示例 3:
//
//        输入:[]
//        输出:[]

public class test_199 {
    public static void main(String[] args) {

    }
}

class Solution71 {
    List<Integer> res = new ArrayList<>();

    //深度优先遍历
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }

    //广度优先遍历
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (i == size - 1) {
//                    res.add(node.val);
//                }
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return res;
//    }

}
