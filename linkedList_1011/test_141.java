import jdk.nashorn.internal.objects.NativeUint8Array;

/**
 * @author chenxin
 * @create 2021-10-11 10:43
 */
public class test_141 {
    public static void main(String[] args) {

    }
}

class Solution15 {
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
