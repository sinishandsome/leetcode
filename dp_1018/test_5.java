/**
 * @author chenxin
 * @create 2021-10-18 9:32
 */


//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
//        示例 1：
//
//        输入：s = "babad"
//        输出："bab"
//        解释："aba" 同样是符合题意的答案。
//        示例 2：
//
//        输入：s = "cbbd"
//        输出："bb"
//        示例 3：
//
//        输入：s = "a"
//        输出："a"
//        示例 4：
//
//        输入：s = "ac"
//        输出："a"
//
//
//        提示：
//
//        1 <= s.length <= 1000
//        s 仅由数字和英文字母（大写和/或小写）组成



public class test_5 {
    public static void main(String[] args) {

    }
}

//中心扩展方法
//class Solution48 {
//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) {
//            return "";
//        }
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s,i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start + 1) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    public int expandAroundCenter(String s, int start, int end) {
//        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
//            --start;
//            ++end;
//        }
//        return end - start - 1;
//    }
//}



//动态规划方法
class Solution48 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        //开始递推
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                int j = L + i - 1;
                if (j >= n) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
