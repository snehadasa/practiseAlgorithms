package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleNumber {
//    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//    Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
//
//
//
//    Example 1:
//
//    Input: nums = [2,2,1]
//    Output: 1
//    Example 2:
//
//    Input: nums = [4,1,2,1,2]
//    Output: 4
//    Example 3:
//
//    Input: nums = [1]
//    Output: 1
//
//
//    Constraints:
//
//            1 <= nums.length <= 3 * 104
//            -3 * 104 <= nums[i] <= 3 * 104
//    Each element in the array appears twice except for one element which appears only once.

    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> countValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (countValue.containsKey(nums[i])) {
                int value = countValue.get(nums[i]);
                countValue.put(nums[i], value + 1);
            } else
                countValue.put(nums[i], 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : countValue.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
            }
        }
        return res;
    }

//    public int singleNumber(int[] nums) {
////        Map<Integer, Integer> countValue = new HashMap<>();
////        for (int i = 0; i < nums.length; i++) {
////            if (countValue.containsKey(nums[i])) {
////                int value = countValue.get(nums[i]);
////                countValue.put(nums[i], value + 1);
////            } else
////                countValue.put(nums[i], 1);
////        }

//        Map<Integer, Integer> num = Arrays.stream(nums).collect(Collectors.groupingBy(n -> ))
    //}

        public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        SingleNumber res = new SingleNumber();
        System.out.println(res.singleNumber1(nums));
    }
}
