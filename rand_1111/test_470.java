/**
 * @author chenxin
 * @create 2021-11-11 15:21
 */

//470. 用 Rand7() 实现 Rand10()
//        已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
//
//        不要使用系统的 Math.random() 方法。
//
//
//
//        示例 1:
//
//        输入: 1
//        输出: [7]
//        示例 2:
//
//        输入: 2
//        输出: [8,4]
//        示例 3:
//
//        输入: 3
//        输出: [8,1,10]
//
//
//        提示:
//
//        rand7 已定义。
//        传入参数: n 表示 rand10 的调用次数。
//
//
//        进阶:
//
//        rand7()调用次数的 期望值 是多少 ?
//        你能否尽量少调用 rand7() ?

public class test_470 {
    public static void main(String[] args) {

    }
}


//1.如何利用一个小范围随机数，得到一个大范围等概率随机数？
//
//        对于 randX,randY，即：(randX - 1) * Y + randY 得到了一个 X*Y 范围的等概率随机数
//
//2.如何利用一个小范围随机数，得到一个确定范围的等概率随机数？
//
//        先采用随机数的 k 进制，得到一个不小于确定范围的随机数 randK，然后对超过确定范围数进行拒绝即可。 注意，如果 K 比确定范围大太多，拒绝策略效率可能就会比较低（经常生成要拒绝的随机数），此时可以把要拒绝的随机数看成一个新的 randM，然后针对这个 randM 再思考怎么用这三个方法也得到确定范围的随机数
//
//3.补充技能
//
//        对于随机数 randN，只要 K 是 N 的约数（或者说 N 是 K 的整数倍），都可以通过 randN 一步得到 randK：randK = (randN % K) + 1;
class Solution83 {
    public int rand10() {
        while (true) {
            int a = rand7();
            int b = rand7();
            int num = (a - 1) * 7 + b;
            if (num <= 40) {
                return num % 10 + 1;
            }


            a = num - 40;
            b = rand7();
            num = (a - 1) * 7 + b;
            if (num <= 60) {
                return num % 10 + 1;
            }

            a = num - 60;
            b = rand7();
            num = (a - 1) * 7 + b;
            if (num <= 20) {
                return num % 10 + 1;
            }
        }
    }

    private int rand7() {
        return 0;
    }
}
