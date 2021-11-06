/**
 * @author chenxin
 * @create 2021-10-19 11:00
 */
public class test_704 {
    public static void main(String[] args) {

    }
}

class Solution51 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low<=high){
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if(target==num){
                return mid;
            } else if (target > num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
