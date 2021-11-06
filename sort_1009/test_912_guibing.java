/**
 * @author chenxin
 * @create 2021-10-09 15:34
 */

//手撕归并排序

public class test_912_guibing {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int[] ints = solution7.sortArray(new int[]{5, 2, 3, 1});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}

class Solution7 {
    int[] tmp;

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int leftP = left, rightP = mid + 1;
        int totalP = 0;
        while (leftP <= mid && rightP <= right) {
            if (nums[leftP] <= nums[rightP]) {
                tmp[totalP++] = nums[leftP++];
            } else {
                tmp[totalP++] = nums[rightP++];
            }
        }
        while (leftP <= mid) {
            tmp[totalP++] = nums[leftP++];
        }
        while (rightP <= right) {
            tmp[totalP++] = nums[rightP++];
        }
        for (int k = 0; k < right - left + 1; k++) {
            nums[k + left] = tmp[k];
        }
    }
}
