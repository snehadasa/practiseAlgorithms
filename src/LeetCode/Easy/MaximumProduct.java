package LeetCode.Easy;

import java.util.Arrays;
import java.util.Collections;

public class MaximumProduct {
//    Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
//
//
//
//            Example 1:
//
//    Input: nums = [1,2,3]
//    Output: 6
//    Example 2:
//
//    Input: nums = [1,2,3,4]
//    Output: 24
//    Example 3:
//
//    Input: nums = [-1,-2,-3]
//    Output: -6
//
//
//    Constraints:
//
//            3 <= nums.length <= 104
//            -1000 <= nums[i] <= 1000

    public boolean containsnegativeAndPositive(int[] arr) {
        boolean negative = false, positive = false;
        for (int a: arr) {
            if (a < 0) {
                negative = true;
            }
        }
        for (int a: arr) {
            if (a > 0) {
                positive = true;
            }
        }
        return negative && positive;
    }

    public static boolean allNegatives(int[] a) {
        return a != null && Arrays.stream(a).allMatch(i -> i < 0);
    }

    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        int[] reverseNums = new int[nums.length];
        int product = 1;
        int max = nums[1]*nums[2]*nums[0];

        for (int i = nums.length-1, j = 0; i >= 0; i--) {
            reverseNums[j++] = nums[i];
        }

        if (containsnegativeAndPositive(nums)) {
            for (int i = 0; i < 3; i++) {
                product = reverseNums[0] * reverseNums[reverseNums.length - 1] * reverseNums[reverseNums.length - 2];

                if (product > max) {
                    max = product;
                }
            }
        }
        else if (allNegatives(nums)) {
            for (int i = 0; i < 3; i++) {
                product *= reverseNums[i];

                if (product > max) {
                    max = product;
                }
            }
        }
        else {
            for (int i = 0; i < 3; i++) {
                product *= reverseNums[i];

                if (product > max) {
                    max = product;
                }
            }
        }
        return product;
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len-1], nums[len-1]*nums[len-2]*nums[len-3]);
    }

    public int maximumProduct3(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

        public int maximumProduct1(int[] nums) {
        int product = 1;
        int max = nums[1]*nums[2]*nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    product = (nums[i] * nums[j] * nums[k]);

                    if (product > max) {
                        max = product;
                    }
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        MaximumProduct res = new MaximumProduct();
        System.out.println(res.maximumProduct(nums));
    }
}
