import java.text.ParseException;

/**
 * @author chenxin
 * @create 2021-10-07 12:51
 */

//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
//        请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//
//        注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。


public class test_88 {
    public static void main(String[] args) {
        Solution1.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}

class Solution1 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int point1 = m - 1;
        int point2 = n - 1;
        int finPoint = m + n - 1;
        int parse;
        while (point1 >= 0 || point2 >= 0) {
            if (point1 == -1) {
                parse = nums2[point2--];
            } else if (point2 == -1) {
                parse = nums1[point1--];
            } else if (nums1[point1] > nums2[point2]) {
                parse = nums1[point1--];
            } else {
                parse = nums2[point2--];
            }

            nums1[finPoint--] = parse;
        }
    }
}
