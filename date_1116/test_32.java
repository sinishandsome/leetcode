import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenxin
 * @create 2021-11-16 15:42
 */


//32. 最长有效括号
//        给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
//
//
//        示例 1：
//
//        输入：s = "(()"
//        输出：2
//        解释：最长有效括号子串是 "()"
//        示例 2：
//
//        输入：s = ")()())"
//        输出：4
//        解释：最长有效括号子串是 "()()"
//        示例 3：
//
//        输入：s = ""
//        输出：0
//
//
//        提示：
//
//        0 <= s.length <= 3 * 104
//        s[i] 为 '(' 或 ')'

public class test_32 {
    public static void main(String[] args) {

    }
}

class Solution88 {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0, start = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        ans = Math.max(ans, i - start + 1);
                    } else {
                        ans = Math.max(ans, i - stack.peek());
                    }
                } else {
                    start = i + 1;
                }
            }
        }
        return ans;
    }
}
