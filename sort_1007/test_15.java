import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenxin
 * @create 2021-10-07 14:58
 */




//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//
//        注意：答案中不可以包含重复的三元组。
//
//         
//
//        示例 1：
//
//        输入：nums = [-1,0,1,2,-1,-4]
//        输出：[[-1,-1,2],[-1,0,1]]
//        示例 2：
//
//        输入：nums = []
//        输出：[]
//        示例 3：
//
//        输入：nums = [0]
//        输出：[]
//         
//
//        提示：
//
//        0 <= nums.length <= 3000
//        -105 <= nums[i] <= 105



public class test_15 {
    public static void main(String[] args) {

    }
}

class Solution2 {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;




//        List<List<Integer>> result = new ArrayList<>();
//        if (nums == null || nums.length <= 2) {
//            return result;
//        }
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums.length < 3) {
//                break;
//            }
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            int target = -nums[i];
//            int leftP = i + 1;
//            int rightP = nums.length - 1;
//            while (leftP < rightP) {
//                if (nums[leftP] + nums[rightP] == target) {
//                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[leftP], nums[rightP])));
//                    leftP++;
//                    rightP--;
//                    while (leftP < rightP && nums[leftP] == nums[leftP - 1]) {
//                        leftP++;
//                    }
//                    while (leftP < rightP && nums[rightP] == nums[rightP + 1]) {
//                        rightP--;
//                    }
//                } else if (nums[leftP] + nums[rightP] < target) {
//                    leftP++;
//                } else {
//                    rightP--;
//                }
//            }
//        }
//        return result;
    }
}
