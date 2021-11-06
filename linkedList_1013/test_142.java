/**
 * @author chenxin
 * @create 2021-10-13 9:03
 */


//给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
//
//        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
//
//        说明：不允许修改给定的链表。
//
//        进阶：
//
//        你是否可以使用 O(1) 空间解决此题？

    //设头结点至环形入口有a个结点 ，整个环形有b个结点 ，快慢结点分别走了f,s步
    //fast走了slow两倍的步数，f=2s
    //fast比slow多走了n个环形，f=s+nb
    //两式相减，s=nb,f=2nb
    //所有指针每一次走到结点入口的步数为a+nb
    //慢指针已经走了s=nb步，还差a步到达结点入口，让快指针回到零点，再走a步到达结点入口


public class test_142 {
    public static void main(String[] args) {

    }
}

class Solution25 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }

}
