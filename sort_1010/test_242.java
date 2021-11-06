import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @create 2021-10-10 15:13
 */


//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//        注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
//
//
//        示例1:
//
//        输入: s = "anagram", t = "nagaram"
//        输出: true
//        示例 2:
//
//        输入: s = "rat", t = "car"
//        输出: false
//
//
//        提示:
//
//        1 <= s.length, t.length <= 5 * 104
//        s 和 t仅包含小写字母
//
//
//        进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？


public class test_242 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        boolean anagram = solution12.isAnagram("a", "ab");
        System.out.println(anagram);

    }
}

class Solution12 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            if (map.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
