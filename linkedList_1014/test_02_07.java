/**
 * @author chenxin
 * @create 2021-10-14 11:13
 */
public class test_02_07 {
    public static void main(String[] args) {

    }
}

class Solution33 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }
}
