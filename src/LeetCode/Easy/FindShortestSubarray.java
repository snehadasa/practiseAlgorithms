package LeetCode.Easy;

import java.util.*;

public class FindShortestSubarray {
//    Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum
//    frequency of any one of its elements.
//
//    Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
//
//
//
//    Example 1:
//
//    Input: nums = [1,2,2,3,1]
//    Output: 2
//    Explanation:
//    The input array has a degree of 2 because both elements 1 and 2 appear twice.
//    Of the subarrays that have the same degree:
//            [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//    The shortest length is 2. So return 2.
//    Example 2:
//
//    Input: nums = [1,2,2,3,1,4,2]
//    Output: 6
//    Explanation:
//    The degree is 3 because the element 2 is repeated 3 times.
//            So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
//
//
//    Constraints:
//
//    nums.length will be between 1 and 50,000.
//    nums[i] will be an integer between 0 and 49,999.

    public int findShortestSubArray1(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
//            if (countMap.containsKey(num)) {
//                int value = countMap.get(num);
//                countMap.put(num, 1+value);
//            } else
//                countMap.put(num, 1);
            countMap.put(num, countMap.getOrDefault(num, 0)+1);  //get count of elements in one line by using getOrDefault;
        }

        int maxFreq = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
            }
        }

        List<Integer> maxList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                maxList.add(entry.getKey());
            }
        }

        int minLen = nums.length;
        for (Integer max : maxList) {
            int firstIndex = -1;
            int lastIndex = nums.length-1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == max) {
                    firstIndex = i;
                    break;
                }
            }

            for (int i = nums.length-1; i >= 0; i--) {
                if (nums[i] == max) {
                    lastIndex = i;
                    break;
                }
            }
            minLen = Math.min(minLen, lastIndex-firstIndex+1);
        }
        return minLen;
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
                right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);   //for first elements if keys are not in map.
            right.put(x, i);   //for last elements to add the last occurance of that element
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,3,1};
        int[] nums2 = {1,2,2,3,1,4,2};
        FindShortestSubarray res = new FindShortestSubarray();
        System.out.println(res.findShortestSubArray(nums1));
        System.out.println(res.findShortestSubArray(nums2));
    }
}
