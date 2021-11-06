/**
 * @author chenxin
 * @create 2021-10-29 14:15
 */
public class test_76 {
    public static void main(String[] args) {
        Solution75 solution = new Solution75();
        String s = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}

class Solution75 {
//    public String minWindow(String s, String t) {
//        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
//            return "";
//        }
//        int[] need = new int[128];
//        int[] have = new int[128];
//        for (int i = 0; i < t.length(); i++) {
//            need[t.charAt(i)]++;
//        }
//
//        int left = 0, right = 0, min = s.length() + 1, count = 0, start = 0;
//        while (right < s.length()) {
//            char r = s.charAt(right);
//            if (need[r] == 0) {
//                right++;
//                continue;
//            }
//
//            if (have[r] < need[r]) {
//                count++;
//            }
//            have[r]++;
//            right++;
//            while (count == t.length()) {
//                if (right - left < min) {
//                    min = right - left;
//                    start = left;
//                }
//                char l = s.charAt(left);
//                if (need[l] == 0) {
//                    left++;
//                    continue;
//                }
//                if (have[l] == need[l]) {
//                    count--;
//                }
//                have[l]--;
//                left++;
//            }
//        }
//        if (min == s.length() + 1) {
//            return "";
//        }
//        return s.substring(start, start + min);
//    }
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;

        int[] hash = new int[128];
        for (char ch : chart) hash[ch]--;

        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0) cnt++;
            while (cnt == m && hash[chars[j]] > 0) hash[chars[j++]]--;
            if (cnt == m)
                if (res.equals("") || res.length() > i - j + 1)
                    res = s.substring(j, i + 1);
        }
        return res;
    }

}
