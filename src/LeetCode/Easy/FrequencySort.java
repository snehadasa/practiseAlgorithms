package LeetCode.Easy;

import java.util.*;
import java.util.stream.Stream;

public class FrequencySort {
    //    Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
//    If multiple values have the same frequency, sort them in decreasing order.
//
//    Return the sorted array.
//
//
//
//    Example 1:
//
//    Input: nums = [1,1,2,2,2,3]
//    Output: [3,1,1,2,2,2]
//    Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
//    Example 2:
//
//    Input: nums = [2,3,1,3,2]
//    Output: [1,3,3,2,2]
//    Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
//            Example 3:
//
//    Input: nums = [-1,1,-6,4,5,-6,1,4,1]
//    Output: [5,-1,4,4,-6,-6,1,1,1]
//
//
//    Constraints:
//
//            1 <= nums.length <= 100
//            -100 <= nums[i] <= 100
    public int[] frequencySort1(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Integer[] numsCopy = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                int value = countMap.get(nums[i]);
                countMap.put(nums[i], value+1);
            } else
                countMap.put(nums[i], 1);
        }

        Arrays.sort(numsCopy, (a, b) -> b - a);
        Arrays.sort(numsCopy, (a, b) -> countMap.get(a) - countMap.get(b));
        return Arrays.stream(numsCopy).mapToInt(Integer::intValue).toArray();
    }

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, List<Integer>> reverseMap = new HashMap<>();
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (countMap.containsKey(nums[i])) {
                int value = countMap.get(nums[i]);
                countMap.put(nums[i], value + 1);
            } else
                countMap.put(nums[i], 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (!reverseMap.containsKey(entry.getValue())) {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                reverseMap.put(entry.getValue(), list);
            } else {
                List<Integer> list = reverseMap.get(entry.getValue());
                list.add(entry.getKey());
            }
        }
        Integer[] keys = reverseMap.keySet().toArray(new Integer[reverseMap.size()]);
        Arrays.sort(keys);
        int i = 0;
        for (Integer key : keys) {
            List<Integer> values = reverseMap.get(key);
            Collections.sort(values, (a, b) -> (b - a));
            for (Integer value : values) {
                for (int j = 0; j < key; j++) {
                    result[i++] = value;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3};
        FrequencySort res = new FrequencySort();
        //System.out.println(Arrays.toString(res.frequencySort(nums)));
        System.out.println(Arrays.toString(res.frequencySort1(nums)));
    }
}
