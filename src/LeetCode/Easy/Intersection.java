package LeetCode.Easy;

import java.util.*;

public class Intersection {
//    Given two arrays, write a function to compute their intersection.
//
//            Example 1:
//
//    Input: nums1 = [1,2,2,1], nums2 = [2,2]
//    Output: [2]
//    Example 2:
//
//    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    Output: [9,4]
//    Note:
//
//    Each element in the result must be unique.
//    The result can be in any order.

    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            nums1Set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2Set.add(nums2[i]);
        }

        nums1Set.retainAll(nums2Set);

        int[] res = new int[nums1Set.size()];
        int i = 0;
        for (int s: nums1Set) {
            res[i++] = s;
        }
        return res;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> common = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    common.add(nums2[j]);
                }
            }
        }
        int[] res = new int[common.size()];
        int index = 0;
        for (Integer commonEl : common) {
            res[index++] = commonEl;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums11 = {4, 9, 5}, nums12 = {9, 4, 9, 8, 4};
        int[] nums21 = {1, 2, 2, 1}, nums22 = {2, 2};
        int[] nums31 = {1}, nums32 = {1};
        int[] nums41 = {1}, nums42 = {1, 1};
        Intersection res = new Intersection();
        System.out.println(Arrays.toString(res.intersection(nums11, nums12)));
        System.out.println(Arrays.toString(res.intersection(nums21, nums22)));
        System.out.println(Arrays.toString(res.intersection(nums31, nums32)));
        System.out.println(Arrays.toString(res.intersection(nums41, nums42)));
    }
}
