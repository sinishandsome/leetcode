import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.awt.font.NumericShaper;
import java.util.Random;

/**
 * @author chenxin
 * @create 2021-10-16 14:57
 */


//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//        请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//
//
//        示例 1:
//
//        输入: [3,2,1,5,6,4] 和 k = 2
//        输出: 5
//        示例2:
//
//        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//        输出: 4
//
//
//        提示：
//
//        1 <= k <= nums.length <= 104
//        -104<= nums[i] <= 104



public class test_215 {
    public static void main(String[] args) {
        Solution36 solution = new Solution36();
        int kthLargest = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }
}

class Solution36 {
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int l, int r, int index) {
        int q = radomPartition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
        }
    }

    public int radomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return paritition(nums, l, r);
    }

    public int paritition(int[] nums, int l, int r) {
        int i = l;
        for (int j = l; j < r; j++) {
            if (nums[j] <= nums[r]) {
                swap(nums, i++, j);
            }
        }
        swap(nums, r, i);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


//class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        int heapSize = nums.length;
//        buildMaxHeap(nums, heapSize);
//        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
//            swap(nums, 0, i);
//            --heapSize;
//            maxHeapify(nums, 0, heapSize);
//        }
//        return nums[0];
//    }
//
//    public void buildMaxHeap(int[] a, int heapSize) {
//        for (int i = heapSize / 2; i >= 0; --i) {
//            maxHeapify(a, i, heapSize);
//        }
//    }
//
//    public void maxHeapify(int[] a, int i, int heapSize) {
//        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
//        if (l < heapSize && a[l] > a[largest]) {
//            largest = l;
//        }
//        if (r < heapSize && a[r] > a[largest]) {
//            largest = r;
//        }
//        if (largest != i) {
//            swap(a, i, largest);
//            maxHeapify(a, largest, heapSize);
//        }
//    }
//
//    public void swap(int[] a, int i, int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
//}

