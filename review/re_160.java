/**
 * @author chenxin
 * @create 2021-11-03 20:08
 */
public class re_160 {
    public static void main(String[] args) {

    }
}
class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
