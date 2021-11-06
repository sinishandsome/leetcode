import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 * @author chenxin
 * @create 2021-10-09 9:12
 */


//链表归并排序

public class test_148 {
    public static void main(String[] args) {

    }
}

class Solution6 {
    public ListNode sortList(ListNode head) {

        //终结条件
        if (head == null || head.next == null) {
            return head;
        }

        //找到链表中心点，切割链表
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return mergeTwoLists(left, right);
    }



    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode r1) {
        ListNode preNOde = new ListNode(-1);
        ListNode pointNode = preNOde;

        while (l1 != null && r1 != null) {
            if (l1.val < r1.val) {
                pointNode.next = l1;
                l1 = l1.next;
            } else {
                pointNode.next = r1;
                r1 = r1.next;
            }

            pointNode = pointNode.next;
        }

        pointNode.next = l1 != null ? l1 : r1;
        return preNOde.next;
    }
}



class ListNode {
    int val;
    ListNode next;   // 下一个链表对象
    ListNode(int x) { val = x; }  //赋值链表的值
}


// 迭代代替递归实现自底向上的归并排序，空间复杂度优于以上为O（1）


//    public ListNode sortList(ListNode head) {
//        // 归并的步长
//        int intv = 1;
//        // 链表长度
//        int len = 0;
//        // 归并的两个前后模块，遍历指针，辅助头结点
//        ListNode h1, h2, pre, res;
//        res = new ListNode(0);
//        res.next = head;
//        // 遍历链表
//        ListNode h = head;
//        // 获得链表长度
//        while (h != null) {
//            h = h.next;
//            len++;
//        }
//        // 自底向上进行归并排序
//        while (intv < len) {
//            pre = res;
//            h = res.next;
//            while (h != null) {
//                int i = intv;
//                h1 = h;
//                // 遍历得到h1
//                while (i > 0 && h != null) {
//                    i--;
//                    h = h.next;
//                }
//                // 如果i>0，则说明只有h1，没有后续的h2了
//                if (i > 0) {
//                    break;
//                }
//                // 重新更新i的值
//                i = intv;
//                h2 = h;
//                // 获得h2部分的长度，有可能长度不到intv
//                while (i > 0 && h != null) {
//                    h = h.next;
//                    i--;
//                }
//                // 分别得到h1部分和h2部分的长度
//                int c1 = intv;
//                int c2 = intv - i;
//                // 对h1和h2进行排序
//                while (c1 > 0 && c2 > 0) {
//                    if (h1.val < h2.val) {
//                        pre.next = h1;
//                        h1 = h1.next;
//                        c1--;
//                    } else {
//                        pre.next = h2;
//                        h2 = h2.next;
//                        c2--;
//                    }
//                    // 更新pre的值，这个值为已排序链表的指针
//                    pre = pre.next;
//                }
//                // 其中一个为0，另一个不为0时，链接剩下的链表
//                pre.next = c1 == 0 ? h2 : h1;
//                // 更新pre指针的位置
//                while (c1 > 0 || c2 > 0) {
//                    pre = pre.next;
//                    c1--;
//                    c2--;
//                }
//                // 链接余下的链表，在下一次循环时，可能会直接break（h1的长度小于intv），不进行h1和h2归并（数量不够），这里就是为了将余下的链表连接起来。
//                // 因为一次intv对应的一次循环，pre指针一定是从开始一直到结尾，整个链表的的长度不能变，如果缺少这一步，最后一部分h1会丢失
//                pre.next = h;
//            }
//            // 更新归并的步长
//            intv *= 2;
//        }
//        return res.next;
//    }
//}