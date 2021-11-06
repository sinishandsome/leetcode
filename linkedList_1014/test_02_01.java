import java.util.HashSet;
import java.util.Set;

/**
 * @author chenxin
 * @create 2021-10-14 10:57
 */

//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

public class test_02_01 {
    public static void main(String[] args) {

    }
}

class Solution32 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> save = new HashSet<>();
        save.add(head.val);
        ListNode cur = head;
        while (cur.next != null) {
            ListNode thisNode = cur.next;
            if (save.add(thisNode.val)) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }
}


