/**
 * @author chenxin
 * @create 2021-11-08 20:05
 */
public class re_92 {
    public static void main(String[] args) {

    }
}

class Solution_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode g = dummy;
        ListNode p = dummy.next;
        for (int i = 1; i < left; i++) {
            g = g.next;
            p = p.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }
        return dummy.next;
    }
}
