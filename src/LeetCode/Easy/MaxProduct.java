package LeetCode.Easy;

import java.util.ArrayList;

public class MaxProduct {
    //    Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum
//    value of (nums[i]-1)*(nums[j]-1).
//
//
//    Example 1:
//
//    Input: nums = [3,4,5,2]
//    Output: 12
//    Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is,
//            (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
//    Example 2:
//
//    Input: nums = [1,5,4,5]
//    Output: 16
//    Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
//    Example 3:
//
//    Input: nums = [3,7]
//    Output: 12
//
//
//    Constraints:
//
//            2 <= nums.length <= 500
//            1 <= nums[i] <= 10^3
    public int maxProduct(int[] nums) {
        int product = 1;
        ArrayList<Integer> prod = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                product = (nums[i] - 1) * (nums[j] - 1);
                prod.add(product);
            }
        }
        int max = prod.get(0);
        for (int i = 0; i < prod.size() - 1; i++) {
            if (prod.get(i) > max) {
                max = prod.get(i);
            }
        }

        return max;
    }

    public int maxProduct1(int[] nums) {
        int max = (nums[0] -1) * (nums[1] - 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = (nums[i] - 1) * (nums[j] - 1);
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2};
        int[] nums2 = {1, 5, 4, 5};
        int[] nums3 = {3, 7};
        MaxProduct res = new MaxProduct();
        System.out.println(res.maxProduct1(nums));
        System.out.println(res.maxProduct1(nums2));
        System.out.println(res.maxProduct1(nums3));
    }
}
