package LeetCode.Easy;

import java.util.Arrays;

public class TwoSum {
//    Given an array of integers that is already sorted in ascending order, find two numbers such that they add up
//    to a specific target number.
//
//    The function twoSum should return indices of the two numbers such that they add up to the target, where
//    index1 must be less than index2.
//
//            Note:
//
//    Your returned answers (both index1 and index2) are not zero-based.
//    You may assume that each input would have exactly one solution and you may not use the same element twice.
//
//
//    Example 1:
//
//    Input: numbers = [2,7,11,15], target = 9
//    Output: [1,2]
//    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
//    Example 2:
//
//    Input: numbers = [2,3,4], target = 6
//    Output: [1,3]
//    Example 3:
//
//    Input: numbers = [-1,0], target = -1
//    Output: [1,2]
//
//
//    Constraints:
//
//            2 <= nums.length <= 3 * 104
//            -1000 <= nums[i] <= 1000
//    nums is sorted in increasing order.
//            -1000 <= target <= 1000

    public int[] twoSum1(int[] numbers, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
               if (numbers[i] + numbers[j] == target) {
                   indices[0] = i+1;
                   indices[1] = j+1;
               }
            }
        }
        return indices;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        while (left < right) {
            int sum = numbers[left]+numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            }
            int mid = left+right / 2;

            if (sum < target) {
                if (numbers[mid] + numbers[right] < target) {
                    left = mid+1;
                } else
                    left = left+1;
            } else {
                if (numbers[mid] + numbers[left] > target) {
                    right = mid+1;
                } else
                    right = right-1;
            }
        }
        return new int[0];
    }

    public int binarySearchForTwoSum(int[] number, int target, int low) {
        int high = number.length-1;
        while (low <= high) {
            int mid = low+(high-low) / 2;
            if (number[mid] == target) {
                return mid;
            }
            else if (number[mid] < target) {
                low = mid+1;
            } else
                high = mid-1;
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int missed = target-numbers[i];
            int missedIdx = binarySearchForTwoSum(numbers, missed, i+1);

            if (missedIdx != -1) {
                res[0] = i+1;
                res[1] = missedIdx+1;
            }
        }
        return res;
    }

        public static void main(String[] args) {
        int[] numbers1 = {2,7,11,15}, numbers2 = {2,3,4};
        int target1 = 9, target2 = 6;
        TwoSum res = new TwoSum();
        System.out.println(Arrays.toString(res.twoSum(numbers1, target1)));
        System.out.println(Arrays.toString(res.twoSum(numbers2, target2)));
    }
}
