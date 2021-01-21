package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
//    Given an array nums of size n, return the majority element.
//
//    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
//    always exists in the array.
//
//
//
//    Example 1:
//
//    Input: nums = [3,2,3]
//    Output: 3
//    Example 2:
//
//    Input: nums = [2,2,1,1,1,2,2]
//    Output: 2
//
//
//    Constraints:
//
//    n == nums.length
//1 <= n <= 5 * 104
//            -231 <= nums[i] <= 231 - 1
//
//
//    Follow-up: Could you solve the problem in linear time and in O(1) space?

    public int majorityElement(int[] nums) {
        int halfLen = nums.length/2;
        Map<Integer, Integer> countNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countNums.containsKey(nums[i])) {
                int value = countNums.get(nums[i]);
                countNums.put(nums[i] , value+1);
            } else
                countNums.put(nums[i], 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : countNums.entrySet()) {
            if (entry.getValue() > halfLen) {
                res = entry.getKey();
            }
        }
        return res;
    }

    public int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement res = new MajorityElement();
        System.out.println(res.majorityElement(nums));
    }
}
