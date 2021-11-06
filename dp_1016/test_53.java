/**
 * @author chenxin
 * @create 2021-10-16 10:39
 */
public class test_53 {
    public static void main(String[] args) {

    }
}

class Solution35 {
    public int maxSubArray(int[] nums) {
        int maxAns = nums[0], pre = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}



//分治算法

//class Solution {
//    public class Status {
//        public int lSum, rSum, mSum, iSum;
//
//        public Status(int lSum, int rSum, int mSum, int iSum) {
//            this.lSum = lSum;
//            this.rSum = rSum;
//            this.mSum = mSum;
//            this.iSum = iSum;
//        }
//    }
//
//    public int maxSubArray(int[] nums) {
//        return getInfo(nums, 0, nums.length - 1).mSum;
//    }
//
//    public Status getInfo(int[] a, int l, int r) {
//        if (l == r) {
//            return new Status(a[l], a[l], a[l], a[l]);
//        }
//        int m = (l + r) >> 1;
//        Status lSub = getInfo(a, l, m);
//        Status rSub = getInfo(a, m + 1, r);
//        return pushUp(lSub, rSub);
//    }
//
//    public Status pushUp(Status l, Status r) {
//        int iSum = l.iSum + r.iSum;
//        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
//        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
//        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
//        return new Status(lSum, rSum, mSum, iSum);
//    }
//}

