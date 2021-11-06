/**
 * @author chenxin
 * @create 2021-11-01 21:11
 */
public class re_53 {
    public static void main(String[] args) {

    }
}


class Solution_53 {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
}