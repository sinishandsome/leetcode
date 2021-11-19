import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenxin
 * @create 2021-11-16 20:41
 */

//144. 二叉树的前序遍历
//        给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
//        示例 1：
//
//
//        输入：root = [1,null,2,3]
//        输出：[1,2,3]
//        示例 2：
//
//        输入：root = []
//        输出：[]
//        示例 3：
//
//        输入：root = [1]
//        输出：[1]
//        示例 4：
//
//
//        输入：root = [1,2]
//        输出：[1,2]
//        示例 5：
//
//
//        输入：root = [1,null,2]
//        输出：[1,2]
//
//
//        提示：
//
//        树中节点数目在范围 [0, 100] 内
//        -100 <= Node.val <= 100

public class test_144 {
    public static void main(String[] args) {

    }
}


//二叉树前序遍历
class Solution89 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }

}
