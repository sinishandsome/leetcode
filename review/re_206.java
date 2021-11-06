/**
 * @author chenxin
 * @create 2021-10-30 9:41
 */
public class re_206 {
    public static void main(String[] args) {

    }
}


class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
