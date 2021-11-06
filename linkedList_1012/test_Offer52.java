/**
 * @author chenxin
 * @create 2021-10-12 9:37
 */
public class test_Offer52 {
    public static void main(String[] args) {

    }
}

class Solution20 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
