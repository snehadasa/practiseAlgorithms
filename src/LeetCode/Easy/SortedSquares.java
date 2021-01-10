package LeetCode.Easy;

import java.util.Arrays;

public class SortedSquares {
//    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each
//    number sorted in non-decreasing order.
//
//
//
//    Example 1:
//
//    Input: nums = [-4,-1,0,3,10]
//    Output: [0,1,9,16,100]
//    Explanation: After squaring, the array becomes [16,1,0,9,100].
//    After sorting, it becomes [0,1,9,16,100].
//    Example 2:
//
//    Input: nums = [-7,-3,2,3,11]
//    Output: [4,9,9,49,121]
//
//
//    Constraints:
//
//            1 <= nums.length <= 104
//            -104 <= nums[i] <= 104
//    nums is sorted in non-decreasing order.

    public int[] sortedSquares(int[] nums) {
        int[] newSq = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length; i++) {
            newSq[j++] = nums[i] * nums[i];
        }
        Arrays.sort(newSq);
        return newSq;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        SortedSquares res = new SortedSquares();
        System.out.println(Arrays.toString(res.sortedSquares(nums)));
    }
}
