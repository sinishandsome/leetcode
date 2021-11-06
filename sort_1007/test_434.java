/**
 * @author chenxin
 * @create 2021-10-07 10:02
 */


//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
//
//        请注意，你可以假定字符串里不包括任何不可打印的字符。
//
//        示例:
//
//        输入: "Hello, my name is John"
//        输出: 5
//        解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。


public class test_434 {

    public static void main(String[] args) {
        int i = Solution.countSegents(" ");
        System.out.println(i);

    }
}


class Solution {
    public static int countSegents(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
//        String[] s1 = s.split("\\s+");
//        if (s1.length == 0) {
//            return 0;
//        }
//        if ("".equals(s1[0])) {
//            return s1.length - 1;
//        } else {
//            return s1.length;
//        }


    }
}



