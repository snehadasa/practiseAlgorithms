package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateII {

//    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
//    such that nums[i] == nums[j] and abs(i - j) <= k.
//
//
//
//            Example 1:
//
//    Input: nums = [1,2,3,1], k = 3
//    Output: true
//    Example 2:
//
//    Input: nums = [1,0,1,1], k = 1
//    Output: true
//    Example 3:
//
//    Input: nums = [1,2,3,1,2,3], k = 2
//    Output: false
//
//
//    Constraints:
//
//            1 <= nums.length <= 105
//            -109 <= nums[i] <= 109
//            0 <= k <= 105

    class Pair {
        public Integer getA() {
            return a;
        }

        public Integer getB() {
            return b;
        }

        Integer a, b;

        public Pair(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                diff = Math.abs(map.get(nums[i]) - i);
                map.put(nums[i], i);
                if (diff <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        ContainsDuplicateII res = new ContainsDuplicateII();
        System.out.println(res.containsNearbyDuplicate(nums, k));
    }
}
