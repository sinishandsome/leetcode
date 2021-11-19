import sun.reflect.annotation.AnnotationSupport;

import java.time.Year;
import java.util.Locale;
import java.util.jar.JarEntry;

/**
 * @author chenxin
 * @create 2021-11-18 16:02
 */
//
//43. 字符串相乘
//        给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
//        示例 1:
//
//        输入: num1 = "2", num2 = "3"
//        输出: "6"
//        示例 2:
//
//        输入: num1 = "123", num2 = "456"
//        输出: "56088"
//        说明：
//
//        num1 和 num2 的长度小于110。
//        num1 和 num2 只包含数字 0-9。
//        num1 和 num2 均不以零开头，除非是数字 0 本身。
//        不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

public class test_43 {
    public static void main(String[] args) {

    }
}

class Solution93 {
    //模拟竖式相加
//    public String multiply(String num1, String num2) {
//        if (num1.equals("0") || num2.equals("0")) {
//            return "0";
//        }
//        String ans = "0";
//        int m = num1.length(), n = num2.length();
//        for (int i = n - 1; i >= 0; i--) {
//            StringBuffer curr = new StringBuffer();
//            int add = 0;
//            for (int j = n - 1; j > i; j--) {
//                curr.append(0);
//            }
//            int y = num2.charAt(i) - '0';
//            for (int j = m - 1; j >= 0; j--) {
//                int x = num1.charAt(j) - '0';
//                int product = x * y + add;
//                curr.append(product % 10);
//                add = product / 10;
//            }
//            if (add != 0) {
//                curr.append(add % 10);
//            }
//            ans = addString(ans, curr.reverse().toString());
//        }
//        return ans;
//    }
//
//    private String addString(String num1, String num2) {
//        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
//        StringBuffer ans = new StringBuffer();
//        while (i >= 0 || j >= 0 || add != 0) {
//            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
//            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
//            int result = x + y + add;
//            ans.append(result % 10);
//            add = result / 10;
//            i--;
//            j--;
//        }
//        ans.reverse();
//        return ans.toString();
//    }




    //根据位置优化乘法
//    该算法是通过两数相乘时，乘数某位与被乘数某位相乘，与产生结果的位置的规律来完成。具体规律如下：
//
//    乘数 num1 位数为 MM，被乘数 num2 位数为 NN， num1 x num2 结果 res 最大总位数为 M+N
//    num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + n1 * n2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();
    }

}
