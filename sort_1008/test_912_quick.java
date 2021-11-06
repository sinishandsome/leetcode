import sun.java2d.pipe.SpanIterator;

import java.util.List;
import java.util.Random;

/**
 * @author chenxin
 * @create 2021-10-08 14:00
 */

//手撕快速排序
public class test_912_quick {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] ints = solution4.sortArray(new int[]{5, 2, 3, 1});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}

class Solution4 {
    public int[] sortArray(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = randomizedPartition(nums, start, end);
            randomizedQuicksort(nums, start, pivot - 1);
            randomizedQuicksort(nums, pivot + 1, end);
        }
    }

    public int randomizedPartition(int[] nums, int start, int end) {
        int pos = new Random().nextInt(end - start + 1) + start;
        swap(nums, pos, end);
        return partition(nums, start, end);
    }

    public int partition(int[] nums, int start, int end) {
        int leftP = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                leftP += 1;
                swap(nums, leftP, i);
            }
        }
        swap(nums, leftP + 1, end);
        return leftP + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int ex = nums[i];
        nums[i] = nums[j];
        nums[j] = ex;
    }
}
