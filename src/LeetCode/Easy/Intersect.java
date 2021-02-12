package LeetCode.Easy;

import java.util.*;

public class Intersect {
//    Given two arrays, write a function to compute their intersection.
//
//            Example 1:
//
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2,2]
//    Example 2:
//
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [4,9]
//    Note:
//
//    Each element in the result should appear as many times as it shows in both arrays.
//    The result can be in any order.
//    Follow up:
//
//    What if the given array is already sorted? How would you optimize your algorithm?
//    What if nums1's size is small compared to nums2's size? Which algorithm is better?
//    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all
//    elements into the memory at once?

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();

        for (int num : nums1) {
            if (map1.containsKey(num)) {
                int value = map1.get(num);
                map1.put(num, 1+value);
            } else {
                map1.put(num, 1);
            }
        }

        for (int num : nums2) {
            if (map2.containsKey(num)) {
                int value = map2.get(num);
                map2.put(num, 1+value);
            } else {
                map2.put(num, 1);
            }
        }

        List<Integer> res = new ArrayList<>();

        for (Integer key : map1.keySet()) {
            for (int i = 0; i < Math.min(map1.get(key), map2.getOrDefault(key, 0)); i++) {
                res.add(key);
            }
        }

//        List<Integer> res = new ArrayList<>();
//        if (nums1.length > nums2.length) {
//            for (int i = 0; i < nums2.length; i++) {
//                for (int j = 0; j < nums1.length; j++) {
//                    if (nums1[j] == nums2[i]) {
//                        res.add(nums1[j]);
//                        break;
//
//                    }
//
//                }
//            }
//        } else if (nums2.length > nums1.length) {
//            for (int i = 0; i < nums1.length; i++) {
//                for (int j = 0; j < nums2.length; j++) {
//                    if (nums2[j] == nums1[i]) {
//                        res.add(nums2[j]);
//                        break;
//                    }
//                }
//            }
//        } else {
//            for (int i = 0; i < nums1.length; i++) {
//                for (int j = 0; j < nums2.length; j++) {
//                    if (nums2[j] == nums1[i]) {
//                        res.add(nums1[i]);
//                        break;
//                    }
//                }
//            }
//        }
        int[] array = res.stream().mapToInt(i -> i).toArray();
        return array;
    }

    public static void main(String[] args) {
        Intersect res = new Intersect();
        int[] nums11 = {3, 1, 2}, nums21 = {1, 1};
        int[] nums12 = {4, 9, 5}, nums22 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(res.intersect(nums11, nums21)));
        System.out.println(Arrays.toString(res.intersect(nums12, nums22)));
    }
}
