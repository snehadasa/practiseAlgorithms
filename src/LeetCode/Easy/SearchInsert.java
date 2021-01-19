package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchInsert {
//    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
//    return the index where it would be if it were inserted in order.
//
//            Example 1:
//
//    Input: nums = [1,3,5,6], target = 5
//    Output: 2
//    Example 2:
//
//    Input: nums = [1,3,5,6], target = 2
//    Output: 1
//    Example 3:
//
//    Input: nums = [1,3,5,6], target = 7
//    Output: 4
//    Example 4:
//
//    Input: nums = [1,3,5,6], target = 0
//    Output: 0
//    Example 5:
//
//    Input: nums = [1], target = 0
//    Output: 0
//
//
//    Constraints:
//
//            1 <= nums.length <= 104
//            -104 <= nums[i] <= 104
//    nums contains distinct values sorted in ascending order.
//            -104 <= target <= 104

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid+1;
            } else
                right = mid-1;
        }
        return left;
    }
//unused method
//    public int insertAndSort(int[] nums, int target) {
//        int res = 0;
//
//        int[] newArr = new int[nums.length+1];
//        for (int i = 0, j = 0; i < nums.length; i++) {
//            newArr[i] = nums[i];
//            newArr[newArr.length - 1] = target;
//        }
//        Arrays.sort(newArr);
//
//        for (int i = 0; i < newArr.length; i++) {
//            if (newArr[i] == target) {
//                res = binarySearch(newArr, target);
//            }
//        }
//        return res;
//    }

    public int searchInsert(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = binarySearch(nums, target);
        }
        return res;
    }

    public static void main(String[] args) {
        SearchInsert res = new SearchInsert();
        int[] nums = {1,3,5,6};
        int target1 = 5, target2 = 7, target3 = 4;
        System.out.println(res.searchInsert(nums, target1));
        System.out.println(res.searchInsert(nums, target2));
        System.out.println(res.searchInsert(nums, target3));
      //  System.out.println(res.binarySearch(nums, target1));
       // System.out.println(res.insertAndSort(nums, target3));
    }
}
