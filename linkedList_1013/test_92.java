import com.sun.org.apache.xpath.internal.axes.PredicatedNodeTest;

/**
 * @author chenxin
 * @create 2021-10-13 10:03
 */
//
//给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
//
//
//        示例 1：
//
//
//        输入：head = [1,2,3,4,5], left = 2, right = 4
//        输出：[1,4,3,2,5]
//        示例 2：
//
//        输入：head = [5], left = 1, right = 1
//        输出：[5]
//
//
//        提示：
//
//        链表中节点数目为 n
//        1 <= n <= 500
//        -500 <= Node.val <= 500
//        1 <= left <= right <= n
//
//
//        进阶： 你可以使用一趟扫描完成反转吗？


public class test_92 {
    public static void main(String[] args) {

    }
}

class Solution26 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        ListNode pre = preNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return preNode.next;
    }
}
