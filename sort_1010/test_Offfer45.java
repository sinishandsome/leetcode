import com.sun.xml.internal.bind.v2.runtime.unmarshaller.LeafPropertyXsiLoader;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenxin
 * @create 2021-10-10 11:19
 */

//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
//
//        示例 1:
//
//        输入: [10,2]
//        输出: "102"
//        示例2:
//
//        输入: [3,30,34,5,9]
//        输出: "3033459"
//
//
//        提示:
//
//        0 < nums.length <= 100
//        说明:
//
//        输出结果可能非常大，所以你需要返回一个字符串而不是整数
//        拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0



public class test_Offfer45 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        String s = solution11.minNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        System.out.println(s);
    }
}

class Solution11 {
    public String minNumber(int[] nums) {
        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }

        Arrays.sort(integers, new Comparator<Integer>(){

            @Override
            public int compare(Integer x, Integer y) {
                long sx = 10, sy = 10;
                while (sx <= x) {
                    sx *= 10;
                }
                while (sy <= y) {
                    sy *= 10;
                }
                return (int) (sy * x + y - sx * y - x);
            }
        });

        StringBuffer ret = new StringBuffer();
        for (int num : integers) {
            ret.append(num);
        }
        return ret.toString();
    }
}
