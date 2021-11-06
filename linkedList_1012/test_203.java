/**
 * @author chenxin
 * @create 2021-10-12 10:33
 */
public class test_203 {
    public static void main(String[] args) {

    }
}

class Solution23 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode point = pre;
        while (point.next != null) {
            if (point.next.val == val) {
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }
        return pre.next;
    }
}
