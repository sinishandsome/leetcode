import java.util.*;

/**
 * @author chenxin
 * @create 2021-11-02 9:51
 */
public class re_102 {
    public static void main(String[] args) {

    }
}

class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = deque.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = deque.poll();
                level.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}
