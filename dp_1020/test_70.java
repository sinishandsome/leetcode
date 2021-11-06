/**
 * @author chenxin
 * @create 2021-10-20 11:18
 */
public class test_70 {
    public static void main(String[] args) {

    }
}

class Solution54 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
