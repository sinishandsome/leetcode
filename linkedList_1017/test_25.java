/**
 * @author chenxin
 * @create 2021-10-17 10:13
 */
//
//给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
//
//        k是一个正整数，它的值小于或等于链表的长度。
//
//        如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//        进阶：
//
//        你可以设计一个只使用常数额外空间的算法来解决此问题吗？
//        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。


public class test_25 {
    public static void main(String[] args) {

    }
}


class Solution37 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return dummy.next;
    }


    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prex = tail.next;
        ListNode p = head;
        while (prex != tail) {
            ListNode nex = p.next;
            p.next = prex;
            prex = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}