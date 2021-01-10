package LeetCode.Easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NumIdenticalPairs {
//    Given an array of integers nums.
//
//    A pair (i,j) is called good if nums[i] == nums[j] and i < j.
//
//    Return the number of good pairs.
//
//
//
//    Example 1:
//
//    Input: nums = [1,2,3,1,1,3]
//    Output: 4
//    Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
//            Example 2:
//
//    Input: nums = [1,1,1,1]
//    Output: 6
//    Explanation: Each pair in the array are good.
//            Example 3:
//
//    Input: nums = [1,2,3]
//    Output: 0
//
//
//    Constraints:
//
//            1 <= nums.length <= 100
//            1 <= nums[i] <= 100

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i < j && nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n1[] = {1,2,3,1,1,3};
        int n2[] = {1, 1, 1, 1};
        NumIdenticalPairs res = new NumIdenticalPairs();
        System.out.println(res.numIdenticalPairs(n1));
        System.out.println(res.numIdenticalPairs(n2));
    }
}
