import sun.java2d.pipe.AAShapePipe;

/**
 * @author chenxin
 * @create 2021-10-12 9:30
 */
public class test_83 {
    public static void main(String[] args) {

    }
}

class Solution24 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode point = head;
        while (point.next != null) {
            if (point.val == point.next.val) {
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }
        return head;
    }
}
