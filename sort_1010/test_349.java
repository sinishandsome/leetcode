import java.util.Arrays;

/**
 * @author chenxin
 * @create 2021-10-10 10:54
 */


//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
//        示例 1：
//
//        输入：nums1 = [1,2,2,1], nums2 = [2,2]
//        输出：[2]
//        示例 2：
//
//        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        输出：[9,4]
//
//
//        说明：
//
//        输出结果中的每个元素一定是唯一的。
//        我们可以不考虑输出结果的顺序。



public class test_349 {
    public static void main(String[] args) {
        int[] num1 = new int[]{4,9,5}, num2 = new int[]{9,4,9,8,4};
        Solution10 solution10 = new Solution10();
        int[] intersection = solution10.intersection(num1, num2);
        for (int i = 0; i < intersection.length; i++) {
            System.out.println(intersection[i]);
        }
    }
}

class Solution10 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] total = new int[len1 + len2];
        int p1 = 0, p2 = 0, pt = 0;
        while (p1 < len1 && p2 < len2) {
            if (nums1[p1] == nums2[p2]) {
                if (pt == 0 || nums1[p1] != total[pt - 1]) {
                    total[pt++] = nums1[p1];
                }
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return Arrays.copyOfRange(total, 0, pt);
    }
}
