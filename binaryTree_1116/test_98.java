import javax.xml.soap.Node;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenxin
 * @create 2021-11-16 14:25
 */

//98. 验证二叉搜索树
//        给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
//        有效 二叉搜索树定义如下：
//
//        节点的左子树只包含 小于 当前节点的数。
//        节点的右子树只包含 大于 当前节点的数。
//        所有左子树和右子树自身必须也是二叉搜索树。
//
//
//        示例 1：
//
//
//        输入：root = [2,1,3]
//        输出：true
//        示例 2：
//
//
//        输入：root = [5,1,4,null,null,3,6]
//        输出：false
//        解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//        提示：
//
//        树中节点数目范围在[1, 104] 内
//        -231 <= Node.val <= 231 - 1

public class test_98 {
    public static void main(String[] args) {

    }
}

class Solution87 {

    //中序遍历栈迭代方法
//    public boolean isValidBST(TreeNode root) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        double preOrder = -Double.MAX_VALUE;
//
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (root.val <= preOrder) {
//                return false;
//            }
//            preOrder = root.val;
//            root = root.right;
//        }
//        return true;
//    }


    //不使用中序遍历的递归方法
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }
}
