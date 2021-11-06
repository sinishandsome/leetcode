import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenxin
 * @create 2021-10-09 16:35
 */
public class test_179 {
    public static void main(String[] args) {

    }
}

class Solution8 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < nums.length; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                long sx = 10, sy = 10;
                while (sx <= o1) {
                    sx *= 10;
                }
                while (sy <= o2) {
                    sy *= 10;
                }
                return (int) (-sy * o1 - o2 + sx * o2 + o1);
            }
        });

        if (numsArr[0] == 0) {
            return "0";
        }

        StringBuffer ret = new StringBuffer();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }
}
