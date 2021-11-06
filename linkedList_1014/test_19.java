/**
 * @author chenxin
 * @create 2021-10-14 8:53
 */
public class test_19 {
    public static void main(String[] args) {

    }
}

class Solution29 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode first = pre, second = pre;
        for (int i = 0; i < n; i++) {
            second = second.next;
            if (second == null) {
                return pre.next.next;
            }
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return pre.next;
    }
}
