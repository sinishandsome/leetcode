import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenxin
 * @create 2021-10-26 9:58
 */

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

public class test_42 {
    public static void main(String[] args) {

    }
}

class Solution64 {
    //双指针法按列求
     public int trap(int[] height) {
        int len = height.length;
        int left = 1;
        int right = len - 2;
        int left_max = 0;
        int right_max = len - 1;

        int res = 0;
        while (left <= right) {
            if (height[left_max] < height[right_max]) {
                if (height[left_max] > height[left]) {
                    res += height[left_max] - height[left];
                } else {
                    left_max = left;
                }
                left++;
            } else {
                if (height[right_max] > height[right]) {
                    res += height[right_max] - height[right];
                } else {
                    right_max = right;
                }
                right--;
            }
        }
        return res;
    }




    //按行求-------------------------------------------------------------------------------
//
//    public int trap(int[] height) {
//        int sum = 0;
//        int max = getMax(height);//找到最大的高度，以便遍历。
//        for (int i = 1; i <= max; i++) {
//            boolean isStart = false; //标记是否开始更新 temp
//            int temp_sum = 0;
//            for (int j = 0; j < height.length; j++) {
//                if (isStart && height[j] < i) {
//                    temp_sum++;
//                }
//                if (height[j] >= i) {
//                    sum = sum + temp_sum;
//                    temp_sum = 0;
//                    isStart = true;
//                }
//            }
//        }
//        return sum;
//    }
//    private int getMax(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (height[i] > max) {
//                max = height[i];
//            }
//        }
//        return max;
//    }

        //栈方法求---------------------------------------------------------------------------
//    public int trap(int[] height) {
//        int ans = 0;
//        Deque<Integer> stack = new LinkedList<Integer>();
//        int n = height.length;
//        for (int i = 0; i < n; ++i) {
//            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
//                int top = stack.pop();
//                if (stack.isEmpty()) {
//                    break;
//                }
//                int left = stack.peek();
//                int currWidth = i - left - 1;
//                int currHeight = Math.min(height[left], height[i]) - height[top];
//                ans += currWidth * currHeight;
//            }
//            stack.push(i);
//        }
//        return ans;
//    }


}
