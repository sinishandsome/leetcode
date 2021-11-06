/**
 * @author chenxin
 * @create 2021-10-20 9:45
 */

//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
//        在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
//        给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
//
//
//
//        示例 1：
//
//        输入：nums = [4,5,6,7,0,1,2], target = 0
//        输出：4
//        示例2：
//
//        输入：nums = [4,5,6,7,0,1,2], target = 3
//        输出：-1
//        示例 3：
//
//        输入：nums = [1], target = 0
//        输出：-1
//
//
//        提示：
//
//        1 <= nums.length <= 5000
//        -10^4 <= nums[i] <= 10^4
//        nums 中的每个值都 独一无二
//        题目数据保证 nums 在预先未知的某个下标上进行了旋转
//        -10^4 <= target <= 10^4
//
//
//        进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？


public class test_33 {
    public static void main(String[] args) {

    }
}
//解法：   将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
//        此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
class Solutio53 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
