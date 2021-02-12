package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMaxConsecutiveOnes {

//    Given a binary array, find the maximum number of consecutive 1s in this array.
//
//            Example 1:
//    Input: [1,1,0,1,1,1]
//    Output: 3
//    Explanation: The first two digits or the last three digits are consecutive 1s.
//    The maximum number of consecutive 1s is 3.
//    Note:
//
//    The input array will only contain 0 and 1.
//    The length of input array is a positive integer and will not exceed 10,000

    public int[] findMaxConsecutiveOnes(int[] nums) {
        boolean one = false;
        int count = 0;
        int max = 0;
        int placevalueMax = 0, placeValueZero = 0;
        for (int i = 0; i < nums.length; i++) {
               if (nums[i] == 1) {
                   count++;
               } else {
                   count = 0;
               }
               if (count > max) {
                   max = count;
                   placevalueMax = i;
               }
        }
        int[] placeValue = new int[2];

        placeValue[0] = placevalueMax + 1 - max;
        placeValue[1] = placevalueMax;
//
//        int max = countArr[0];
//        for (int i = 0; i < countArr.length; i++) {
//            max = Math.max(max, countArr[i]);
//        }
        return placeValue;
    }

        public static void main(String[] args) {
        int []nums = {1,1,0,1,1,1};
        FindMaxConsecutiveOnes res = new FindMaxConsecutiveOnes();
        System.out.println(Arrays.toString(res.findMaxConsecutiveOnes(nums)));
    }
}
