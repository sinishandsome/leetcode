import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxin
 * @create 2021-11-14 20:39
 */

//78. 子集
//        给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//        解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
//        示例 1：
//
//        输入：nums = [1,2,3]
//        输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//        示例 2：
//
//        输入：nums = [0]
//        输出：[[],[0]]
//
//
//        提示：
//
//        1 <= nums.length <= 10
//        -10 <= nums[i] <= 10
//        nums 中的所有元素 互不相同

public class test_78 {
    public static void main(String[] args) {

    }
}

class Solution86 {
    List<Integer> team = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int i, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(team));
            return;
        }
        team.add(nums[i]);
        dfs(i + 1, nums);
        team.remove(team.size() - 1);
        dfs(i + 1, nums);
    }
}
