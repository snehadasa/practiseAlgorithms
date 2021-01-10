package CodingBat;

import java.util.Arrays;

public class ZeroMax {

//    Return a version of the given array where each zero value in the array is replaced by the largest
//    odd value to the right of the zero in the array. If there is no odd value to the right
//    of the zero, leave the zero as a zero.
//
//
//            zeroMax([0, 5, 0, 3]) → [5, 5, 3, 3]
//    zeroMax([0, 4, 0, 3]) → [3, 4, 3, 3]
//    zeroMax([0, 1, 0]) → [1, 1, 0]

    public int[] zeroMax(int[] nums) {
        int largestODDNumber = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 2 == 1) {
                largestODDNumber = Math.max(largestODDNumber, nums[i]);
            }
            if (nums[i] == 0) {
                nums[i] = largestODDNumber;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] n1 = {0, 4, 3, 3};
        int[] n2 = {7, 0, 4, 3, 0, 2};
        int[] n3 = {7, 0, 1, 0, 0, 7};
        ZeroMax res = new ZeroMax();
        System.out.println(Arrays.toString(res.zeroMax(n1)));
        System.out.println(Arrays.toString(res.zeroMax(n2)));
        System.out.println(Arrays.toString(res.zeroMax(n3)));
    }
}
