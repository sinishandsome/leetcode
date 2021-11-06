import java.awt.font.NumericShaper;

/**
 * @author chenxin
 * @create 2021-10-10 9:59
 */


//给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//        此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
//
//
//
//        示例 1：
//
//        输入：nums = [2,0,2,1,1,0]
//        输出：[0,0,1,1,2,2]
//        示例 2：
//
//        输入：nums = [2,0,1]
//        输出：[0,1,2]
//        示例 3：
//
//        输入：nums = [0]
//        输出：[0]
//        示例 4：
//
//        输入：nums = [1]
//        输出：[1]
//
//
//        提示：
//
//        n == nums.length
//        1 <= n <= 300
//        nums[i] 为 0、1 或 2
//
//
//        进阶：
//
//        你可以不使用代码库中的排序函数来解决这道题吗？
//        你能想出一个仅使用常数空间的一趟扫描算法吗？


public class test_75 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0};
        Solution9 solution9 = new Solution9();
        solution9.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

class Solution9 {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        int car;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                car = nums[i];
                nums[i] = nums[p1];
                nums[p1] = car;
                ++p1;
            }
            if (nums[i] == 0) {
                car = nums[i];
                nums[i] = nums[p0];
                nums[p0] = car;
                if (p0 < p1) {
                    car = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = car;
                }
                ++p0;
                ++p1;
            }

        }
    }
}
