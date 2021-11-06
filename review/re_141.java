
/**
 * @author chenxin
 * @create 2021-11-02 9:11
 */
public class re_141 {
    public static void main(String[] args) {

    }
}

class Solution_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }
}
