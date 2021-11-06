/**
 * @author chenxin
 * @create 2021-11-03 19:38
 */

//151. 翻转字符串里的单词
//        给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
//
//        单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
//
//        请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
//
//        说明：
//
//        输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
//        翻转后单词间应当仅用一个空格分隔。
//        翻转后的字符串中不应包含额外的空格。
//
//
//        示例 1：
//
//        输入：s = "the sky is blue"
//        输出："blue is sky the"
//        示例 2：
//
//        输入：s = "  hello world  "
//        输出："world hello"
//        解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
//        示例 3：
//
//        输入：s = "a good   example"
//        输出："example good a"
//        解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
//        示例 4：
//
//        输入：s = "  Bob    Loves  Alice   "
//        输出："Alice Loves Bob"
//        示例 5：
//
//        输入：s = "Alice does not even like bob"
//        输出："bob like even not does Alice"
//
//
//        提示：
//
//        1 <= s.length <= 104
//        s 包含英文大小写字母、数字和空格 ' '
//        s 中 至少存在一个 单词

public class test_151 {
    public static void main(String[] args) {

    }
}

class Solution76 {
    public String reverseWords(String s) {
        //去除多余的空格
        StringBuilder sb = trimString(s);
        //翻转字符串
        reverse(sb, 0, sb.length() - 1);
        //翻转每个单词
        reverseEachWord(sb);
        return sb.toString();

    }

    private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;
        while (start < n) {
            //end循环到单词末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            //翻转单词
            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    private StringBuilder trimString(String s) {
        int left = 0, right = s.length() - 1;
        //去掉开头空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        //去掉末尾空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }
        //将单词间的空格去重
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
                //如果sb中已经存在一个空格，则无需再次添加
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }
}
