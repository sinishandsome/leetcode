import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenxin
 * @create 2021-11-04 16:27
 */
public class re_103 {
    public static void main(String[] args) {

    }
}

class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        boolean isOrder = true;
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodeQueue.poll();
                if (isOrder) {
                    level.offerLast(cur.val);
                } else {
                    level.offerFirst(cur.val);
                }
                if (cur.left != null) {
                    nodeQueue.offer(cur.left);
                }
                if (cur.right != null) {
                    nodeQueue.offer(cur.right);
                }
            }
            ans.add(new LinkedList<>(level));
            isOrder = !isOrder;
        }
        return ans;
    }
}
