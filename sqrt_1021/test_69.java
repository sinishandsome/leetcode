/**
 * @author chenxin
 * @create 2021-10-21 11:14
 */

//给你一个非负整数 x ，计算并返回x的 算术平方根 。
//
//        由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
//        注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
//
//
//        示例 1：
//
//        输入：x = 4
//        输出：2
//        示例 2：
//
//        输入：x = 8
//        输出：2
//        解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//
//
//        提示：
//
//        0 <= x <= 231 - 1


public class test_69 {
    public static void main(String[] args) {

    }
}


class Solution55 {
    //二分查找
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }
        return ans;
    }


    //牛顿迭代
//    public int mySqrt(int x) {
//        if (x == 0) {
//            return 0;
//        }
//
//        double C = x, x0 = x;
//        while (true) {
//            double xi = 0.5 * (x0 + C / x0);
//            if (Math.abs(x0 - xi) < 1e-7) {
//                break;
//            }
//            x0 = xi;
//        }
//        return (int) x0;
//    }

}
