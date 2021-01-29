package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
//    Given an array of integers, find if the array contains any duplicates.
//
//    Your function should return true if any value appears at least twice in the array, and it should return false if
//    every element is distinct.
//
//    Example 1:
//
//    Input: [1,2,3,1]
//    Output: true
//    Example 2:
//
//    Input: [1,2,3,4]
//    Output: false
//    Example 3:
//
//    Input: [1,1,1,3,3,4,3,2,4,2]
//    Output: true

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]);
                map.put(nums[i], 1+value);
            } else
                map.put(nums[i], 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }

//    public boolean containsDuplicate(int[] nums) {
//
//    }

        public static void main(String[] args) {
        int[] nums1 = {1,1,1,3,3,4,3,2,4,2};
        int[] nums2 = {1,2,3,4};
        ContainsDuplicate res = new ContainsDuplicate();
        System.out.println(res.containsDuplicate(nums1));
        System.out.println(res.containsDuplicate(nums2));
    }
}
