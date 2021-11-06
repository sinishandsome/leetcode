/**
 * @author chenxin
 * @create 2021-10-12 9:49
 */
public class test_876 {
    public static void main(String[] args) {

    }
}

class Solution21 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
