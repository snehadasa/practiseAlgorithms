package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UniqueOccurences {
//    Given an array of integers arr, write a function that returns true if and only if the number of occurrences of
//    each value in the array is unique.
//
//
//
//    Example 1:
//
//    Input: arr = [1,2,2,1,1,3]
//    Output: true
//    Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
//            Example 2:
//
//    Input: arr = [1,2]
//    Output: false
//    Example 3:
//
//    Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
//    Output: true
//
//
//    Constraints:
//
//            1 <= arr.length <= 1000
//            -1000 <= arr[i] <= 1000


    public boolean uniqueOccurrences(int[] arr) {
       Map<Integer, Integer> map = new HashMap<>();

       for (int num:arr) {
           if (!map.containsKey(num)) {
               map.put(num, 1);
           } else {
               map.put(num, map.get(num) + 1);
           }
       }

       for (int key1:map.keySet()) {
           for (int key2:map.keySet()) {
               if (key1 != key2 && map.get(key1) == map.get(key2)) {
                   return false;
               }
           }
       }
        return true;
    }

        public static void main(String[] args) {
        int[] arr1 = {1,2,2,1,1,3};
        int[] arr2 = {-3,0,1,-3,1,1,1,-3,10,0};
        int[] arr3 = {1,2};
        UniqueOccurences res = new UniqueOccurences();
        System.out.println(res.uniqueOccurrences(arr1));
        System.out.println(res.uniqueOccurrences(arr2));
        System.out.println(res.uniqueOccurrences(arr3));
    }
}
