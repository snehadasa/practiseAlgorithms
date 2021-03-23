package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {
//    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest
//    sum and return its sum.
//
//
//
//    Example 1:
//
//    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    Output: 6
//    Explanation: [4,-1,2,1] has the largest sum = 6.
//    Example 2:
//
//    Input: nums = [1]
//    Output: 1
//    Example 3:
//
//    Input: nums = [5,4,-1,7,8]
//    Output: 23
//
//
//    Constraints:
//
//            1 <= nums.length <= 3 * 104
//            -105 <= nums[i] <= 105
//
//
//    Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and
//    conquer approach, which is more subtle.

    public int maxSubArray1(int[] nums) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                list.add(sum);
                sum = 0;
            }
        }
        int max = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int sum = 0, maxSum = nums[0];
        int sumArray[] = new int[nums.length];
        sumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArray[i] = sumArray[i-1] + nums[i];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = sumArray[j] - (i == 0 ? 0 : sumArray[i-1]);

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public int maxSubArray3(int[] nums) {
        int max = nums[0], currentMax = 0;

        for (int num: nums) {
            currentMax += num;

            if (currentMax > max) {
                max = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        return max;
    }

//    public int maxSubArray(int[] nums) {
//
//    }

        public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray res = new MaxSubArray();
        System.out.println(res.maxSubArray2(nums));
    }
}
