/**
 * @author chenxin
 * @create 2021-10-13 16:33
 */
public class test_Offer18 {
    public static void main(String[] args) {

    }
}

class Solution28 {
    public ListNode deleteNode(ListNode head, int val) {

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        pre.next = head;
        while (pre.next != null) {
            ListNode next = pre.next;
            if (next.val == val) {
                pre.next = next.next;
                continue;
            }
            pre = pre.next;
        }
        return cur.next;
    }
}
