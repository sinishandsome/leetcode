/**
 * @author chenxin
 * @create 2021-10-11 9:56
 */


//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

public class test_206 {

}


class Solution14 {
    //遍历方式
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }



    //递归方式
//    public ListNode reverseList(ListNode head) {
//        // 1. 递归终止条件
//        if (head == null || head.next == null) {
//            return head;
//        }

          // 递

//        ListNode p = reverseList(head.next);

          // 归

//        head.next.next = head;
//        head.next = null;
//        return p;
//    }


}



