import java.sql.PreparedStatement;

/**
 * @author chenxin
 * @create 2021-11-01 9:02
 */
public class re_25 {
    public static void main(String[] args) {

    }
}

class Solution_25 {
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
            //反转后链表拼接
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode point = head;
        while (pre != tail) {
            ListNode nex = point.next;
            point.next = pre;
            pre = point;
            point = nex;
        }
        return new ListNode[]{tail, head};
    }
}
