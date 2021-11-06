import com.sun.corba.se.spi.orb.ParserImplBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenxin
 * @create 2021-10-22 10:19
 */
public class test_46 {
    public static void main(String[] args) {

    }
}

class Solution56 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, i, first);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, i, first);
        }
    }
}
