package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpecialArray {
//    You are given an array nums of non-negative integers. nums is considered special if there exists a number x such
//    that there are exactly x numbers in nums that are greater than or equal to x.
//
//    Notice that x does not have to be an element in nums.
//
//    Return x if the array is special, otherwise, return -1. It can be proven that if nums is special,
//    the value for x is unique.
//
//
//
//            Example 1:
//
//    Input: nums = [3,5]
//    Output: 2
//    Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
//    Example 2:
//
//    Input: nums = [0,0]
//    Output: -1
//    Explanation: No numbers fit the criteria for x.
//    If x = 0, there should be 0 numbers >= x, but there are 2.
//    If x = 1, there should be 1 number >= x, but there are 0.
//    If x = 2, there should be 2 numbers >= x, but there are 0.
//    x cannot be greater since there are only 2 numbers in nums.
//            Example 3:
//
//    Input: nums = [0,4,3,0,4]
//    Output: 3
//    Explanation: There are 3 values that are greater than or equal to 3.
//    Example 4:
//
//    Input: nums = [3,6,7,7,0]
//    Output: -1
//
//
//    Constraints:
//
//            1 <= nums.length <= 100
//            0 <= nums[i] <= 1000

    public int specialArray(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    count++;
                }
                map.put(i, count);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int specialArray1(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length; i >= 1; i--) {
            if (nums[nums.length - i] >= i) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid+1;
            } else
                right = mid-1;
        }
        return left;
    }

    public int specialArray2(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length; i >= 1; i--) {
            int numElementsGreaterThanOrEqualToI = nums.length - binarySearch(nums, i);
            if (i == numElementsGreaterThanOrEqualToI) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0, 4};
        int[] nums1 = {3, 5};
        SpecialArray res = new SpecialArray();
        System.out.println(res.specialArray1(nums));
        System.out.println(res.specialArray1(nums1));
    }
}
