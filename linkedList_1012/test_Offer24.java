/**
 * @author chenxin
 * @create 2021-10-12 10:03
 */
public class test_Offer24 {
    public static void main(String[] args) {

    }
}

class Solution22 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode point = head;
        while (point != null) {
            ListNode next = point.next;
            point.next = pre;
            pre = point;
            point = next;
        }
        return pre;
    }
}
