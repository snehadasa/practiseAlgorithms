package CodingBat;

import java.util.Arrays;

public class BigDiff {

//    Given an array length 1 or more of ints, return the difference between the largest and
//    smallest values in the array. Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods
//    return the smaller or larger of two values.
//
//
//            bigDiff([10, 3, 5, 6]) → 7
//    bigDiff([7, 2, 10, 9]) → 8
//    bigDiff([2, 10, 7, 2]) → 8

    public int bigDiff(int[] nums) {
        int minV = nums[0];
        int maxV = nums[0];
        int diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] > maxV)
//                maxV = nums[i];
//            if (nums[i] < minV)
//                minV = nums[i];
            maxV = Arrays.stream(nums).max().getAsInt();
            minV = Arrays.stream(nums).min().getAsInt();
            diff = maxV - minV;
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] n1 = {10, 3, 5, 6};
        int[] n2 = {7, 2, 10, 9};
        int[] n3 = {2, 10, 7, 2};
        BigDiff res = new BigDiff();
        System.out.println(res.bigDiff(n1));
        System.out.println(res.bigDiff(n2));
        System.out.println(res.bigDiff(n3));
    }
}
