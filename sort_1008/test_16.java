import java.util.Arrays;

/**
 * @author chenxin
 * @create 2021-10-08 8:59
 */



//给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//
//
//        示例：
//
//        输入：nums = [-1,2,1,-4], target = 1
//        输出：2
//        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//        提示：
//
//        3 <= nums.length <= 10^3
//        -10^3<= nums[i]<= 10^3
//        -10^4<= target<= 10^4


public class test_16 {
    public static void main(String[] args) {
        int i = Solution3.threeSumClosest(new int[]{0,2,1,-3}, 1);
        System.out.println(i);

    }
}

class Solution3 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int snum = 100000;
        for (int i = 0; i < n - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;

            }
            int leftP = i + 1;
            int rightP = n - 1;

            while (leftP < rightP) {

                int sum = nums[leftP] + nums[rightP] + nums[i];

                if (sum == target) {
                    return sum;
                }

                if (Math.abs(sum - target) < Math.abs(snum - target)) {
                    snum = sum;
                }

                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = rightP - 1;
                    // 移动到下一个不相等的元素
                    while (leftP < k0 && nums[k0] == nums[rightP]) {
                        --k0;
                    }
                    rightP = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = leftP + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < rightP && nums[j0] == nums[leftP]) {
                        ++j0;
                    }
                    leftP = j0;
                }

            }
        }
        return snum;
    }
}

