/**
 * @author chenxin
 * @create 2021-10-13 15:20
 */

//重排链表，后半反转后交替重组

public class test_143 {
    public static void main(String[] args) {

    }
}

class Solution27 {
    public void reorderList(ListNode head) {
        //1.找出链表中点
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //2.中点切断，反转后半链表
        ListNode head2 = null;
        ListNode backCur = slow.next;
        slow.next = null;
        while (backCur != null) {
            ListNode next = backCur.next;
            backCur.next = head2;
            head2 = backCur;
            backCur = next;
        }
        //3.交替拼接链表
        ListNode cur = head;
        ListNode cur2 = head2;
        while (cur != null && cur2 != null) {
            ListNode next = cur.next;
            cur.next = cur2;
            cur2 = cur2.next;
            cur.next.next = next;
            cur = next;

        }
    }
}
