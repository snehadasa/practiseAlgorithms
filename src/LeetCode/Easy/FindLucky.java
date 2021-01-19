package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLucky {
//    Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
//
//    Return a lucky integer in the array. If there are multiple lucky integers return the largest of them.
//    If there is no lucky integer return -1.
//
//
//
//    Example 1:
//
//    Input: arr = [2,2,3,4]
//    Output: 2
//    Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
//    Example 2:
//
//    Input: arr = [1,2,2,3,3,3]
//    Output: 3
//    Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
//    Example 3:
//
//    Input: arr = [2,2,2,3,3]
//    Output: -1
//    Explanation: There are no lucky numbers in the array.
//    Example 4:
//
//    Input: arr = [5]
//    Output: -1
//    Example 5:
//
//    Input: arr = [7,7,7,7,7,7,7]
//    Output: 7
//
//
//    Constraints:
//
//            1 <= arr.length <= 500
//            1 <= arr[i] <= 500

    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int iterator: arr) {
            if (map.containsKey(iterator)) {
                int value = map.get(iterator);
                map.put(iterator, 1+value);
            } else
                map.put(iterator, 1);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                res.add(entry.getKey());
            }
        }
        int max = -1;
        if (res.size() > 0) {
            max = res.get(res.size() - 1);
            for (int i = 0; i < res.size(); i++) {
                max = Math.max(res.get(i), max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3};
        int[] arr1 = {2,2,2,3,3};
        int[] arr2 = {2,2,3};
        FindLucky res = new FindLucky();
        System.out.println(res.findLucky(arr));
        System.out.println(res.findLucky(arr1));
        System.out.println(res.findLucky(arr2));
    }
}
