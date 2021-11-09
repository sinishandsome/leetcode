import sun.security.util.Length;

/**
 * @author chenxin
 * @create 2021-11-06 14:31
 */
public class re_5 {
    public static void main(String[] args) {

    }
}

class Solution_5 {
    //中心扩展算法
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = findExpend(s, i, i);
            int len2 = findExpend(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int findExpend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
