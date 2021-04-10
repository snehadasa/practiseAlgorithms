package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLengthOfLCIS {
//    Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence
//            (i.e. subarray). The subsequence must be strictly increasing.
//
//    A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l],
//    nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
//
//
//
//    Example 1:
//
//    Input: nums = [1,3,5,4,7]
//    Output: 3
//    Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
//    Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
//4.
//    Example 2:
//
//    Input: nums = [2,2,2,2,2]
//    Output: 1
//    Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
//    increasing.

    public int findLengthOfLCIS(int[] nums) {
        int maxCount = 1;
        int count = 1;

        if (nums.length == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count = 1;
            }
        }
        return maxCount;
    }

    public int findLengthOfLCIS2(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

    public int numberOfElementsArrayContains(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return map.size();
    }
    public int findLengthOfLCIS1(int[] nums) {
       int count  = 0;
       List<Integer> list = new ArrayList<>();
       boolean isSameOrContinous = false;
       int mapSize = numberOfElementsArrayContains(nums);

       if (mapSize == 1) {
           list.add(1);
       } else {
           for (int i = 0; i < nums.length; i++) {
               if (i < nums.length - 1 && nums[i] < nums[i + 1]) {
                   isSameOrContinous = true;
               }
               if (isSameOrContinous) {
                   count++;
                   list.add(count);
               }
               if (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                   isSameOrContinous = false;
                   list.add(1);
               count = 0;
               }
           }
       }
       int max = 0;
       if (list.size() >= 1) {
           max = list.get(0);

           for (int i = 0; i < list.size(); i++) {
               if (list.get(i) > max) {
                   max = list.get(i);
               }
           }
       }
       return max;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,4,7};
        int[] nums2 = {2,2,2,2,2};
        int[] nums3 = {1,3,5,4,2,3,4,5};
        int[] nums4 = {};
        int[] nums5 = {2,1};
        FindLengthOfLCIS res = new FindLengthOfLCIS();
//        System.out.println(res.findLengthOfLCIS(nums1));
//        System.out.println(res.findLengthOfLCIS(nums2));
//        System.out.println(res.findLengthOfLCIS(nums3));
//        System.out.println(res.findLengthOfLCIS(nums4));
        System.out.println(res.findLengthOfLCIS(nums5));
    }
}
