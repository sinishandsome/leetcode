import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

/**
 * @author chenxin
 * @create 2021-10-14 9:25
 */



//给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//
//        请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//        你可以假设除了数字 0 之外，这两个数都不会以 0开头。


public class test_2 {
    public static void main(String[] args) {

    }
}

class Solution30 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode pre = dummy;
        int carry = 0, result = 0;
        while (cur1 != null || cur2 != null || carry > 0) {
            result = (cur1 == null ? 0 : cur1.val) + (cur2 == null ? 0 : cur2.val) + carry;
            carry = result / 10;
            result %= 10;
            pre.next = new ListNode(result);
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
            pre = pre.next;
        }
        return dummy.next;

    }
}
