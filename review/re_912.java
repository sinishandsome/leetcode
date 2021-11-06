import java.util.Random;

/**
 * @author chenxin
 * @create 2021-11-01 9:39
 */
public class re_912 {
    public static void main(String[] args) {
        Solution_912 solution = new Solution_912();
        int[] ints = solution.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        System.out.println(ints.toString());

    }
}

class Solution_912 {
    Random random = new Random();
    public int[] sortArray(int[] nums) {
        startQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void startQuickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = findPoint(nums, l, r);
            startQuickSort(nums, l, pos - 1);
            startQuickSort(nums, pos + 1, r);
        }

    }

    private int findPoint(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return quickSort(nums, l, r);
    }

    private int quickSort(int[] nums, int l, int r) {
        int j = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < nums[r]) {
                swap(nums, j, i);
                j++;
            }
        }
        swap(nums, j, r);
        return j;
    }

    private void swap(int[] nums, int i, int r) {
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
    }
}
