import java.util.Arrays;

/**
 * @author chenxin
 * @create 2021-10-10 16:11
 */


//手撕堆排序

public class test_912_dui {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int[] ints = solution13.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}

class Solution13 {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        int len = nums.length;
        int i;
        //创建大顶堆 n-1为堆尾索引，该位置的父结点为 (n-1)-1 除以2
        for (i = (len >> 1) - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }

        //排序，首尾交换，大顶换到尾部，每次循环再保留末尾最大的节点
        for (i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    public void heapify(int[] arr, int n, int i) {
        int largest = i;
        int lson = (i << 1) + 1;
        int rson = (i << 1) + 2;

        if (lson < n && arr[largest] < arr[lson]) {
            largest = lson;
        }
        if (rson < n && arr[largest] < arr[rson]) {
            largest = rson;
        }
        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
