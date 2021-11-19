import sun.reflect.annotation.AnnotationSupport;

/**
 * @author chenxin
 * @create 2021-11-14 19:19
 */

//718. 最长重复子数组
//        给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
//
//
//        示例：
//
//        输入：
//        A: [1,2,3,2,1]
//        B: [3,2,1,4,7]
//        输出：3
//        解释：
//        长度最长的公共子数组是 [3, 2, 1] 。
//
//
//        提示：
//
//        1 <= len(A), len(B) <= 1000
//        0 <= A[i], B[i] < 100

public class test_718 {
    public static void main(String[] args) {

    }
}

class Solution85 {
    public int findLength(int[] nums1, int[] nums2) {
        //动态规划法
//        int m = nums1.length, n = nums2.length;
//        int[][] dp = new int[m + 1][n + 1];
//        int ans = 0;
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (nums1[i - 1] == nums2[j - 1]) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                    ans = Math.max(dp[i][j], ans);
//                }
//            }
//        }
//        return ans;





        //滑动窗口法
        return nums1.length < nums2.length ? findMax(nums1, nums2) : findMax(nums2, nums1);


    }

    private int findMax(int[] nums1, int[] nums2) {
        int max = 0;
        int an = nums1.length, bn = nums2.length;
        for (int len = 1; len <= an; len++) {
            max = Math.max(max, maxLen(nums1, 0, nums2, bn - len, len));
        }
        for (int j = bn - an; j >= 0; j--) {
            max = Math.max(max, maxLen(nums1, 0, nums2, j, an));
        }
        for (int i = 1; i < an; i++) {
            max = Math.max(max, maxLen(nums1, i, nums2, 0, an - i));
        }
        return max;
    }

    private int maxLen(int[] nums1, int i, int[] nums2, int j, int len) {
        int count = 0, max = 0;
        for (int k = 0; k < len; k++) {
            if (nums1[i + k] == nums2[j + k]) {
                count++;
            } else if (count > 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return count > 0 ? Math.max(max, count) : max;
    }
}
