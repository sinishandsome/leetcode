import java.util.HashSet;
import java.util.Set;

/**
 * @author chenxin
 * @create 2021-10-30 10:38
 */
public class re_3 {
    public static void main(String[] args) {

    }
}

class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int point = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (point < n && !set.contains(s.charAt(point))) {
                set.add(s.charAt(point));
                ++point;
            }
            ans = Math.max(ans, point - i);
        }
        return ans;
    }
}
