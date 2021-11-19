import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxin
 * @create 2021-11-17 19:51
 */

//22. 括号生成
//        数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//        有效括号组合需满足：左括号必须以正确的顺序闭合。
//
//
//
//        示例 1：
//
//        输入：n = 3
//        输出：["((()))","(()())","(())()","()(())","()()()"]
//        示例 2：
//
//        输入：n = 1
//        输出：["()"]
//
//
//        提示：
//
//        1 <= n <= 8

public class test_22 {
    public static void main(String[] args) {

    }
}

class Solution91 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private void getParenthesis(String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left == right) {
            getParenthesis(str + "(", left - 1, right);
        } else {
            if (right > 0) {
                getParenthesis(str + ")", left, right - 1);
            }
            getParenthesis(str + "(", left - 1, right);
        }
    }
}
