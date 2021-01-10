package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;

public class Shuffle {
//    Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
//
//    Return the array in the form [x1,y1,x2,y2,...,xn,yn].
//
//
//
//    Example 1:
//
//    Input: nums = [2,5,1,3,4,7], n = 3
//    Output: [2,3,5,4,1,7]
//    Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
//    Example 2:
//
//    Input: nums = [1,2,3,4,4,3,2,1], n = 4
//    Output: [1,4,2,3,3,2,4,1]
//    Example 3:
//
//    Input: nums = [1,1,2,2], n = 2
//    Output: [1,2,1,2]
//
//
//    Constraints:
//
//            1 <= n <= 500
//    nums.length == 2n
//1 <= nums[i] <= 10^3

    public int[] shuffle1(int[] nums, int n) {
        int[] numsTillMid = new int[n];
        int[] numsMidToEnd = new int[nums.length - n];
        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            numsTillMid[i] = nums[i];
        }
        for (int i = 0; i < nums.length - n; i++) {
            numsMidToEnd[i] = nums[n + i];
        }
        int j = 0;
        for (int i = 0; i < numsTillMid.length && i < numsMidToEnd.length; i++) {
            res[j++] = numsTillMid[i];
            res[j++] = numsMidToEnd[i];
        }
        if (numsTillMid.length > numsMidToEnd.length) {
            for (int i = numsMidToEnd.length; i < numsTillMid.length; i++) {
                res[j++] = numsTillMid[i];
            }
        } else if (numsTillMid.length < numsMidToEnd.length) {
            for (int i = numsTillMid.length; i < numsMidToEnd.length; i++) {
                res[j++] = numsMidToEnd[i];
            }
        }
        return res;
    }
//        int[] res = new int[nums.length];
//        int j = 0;
//        for (int i = 0; i < n && n + i < nums.length; i++) {
//            res[j++] = nums[i];
//            res.add(nums[n+i]);
//        }
//        if (n < nums.length - n) {
//            for (int i = 2*n ; i < nums.length; i++) {
//                res.add(nums[i]);
//            }
//        } else if (n > nums.length - n) {
//            for (int i = nums.length - n ; i < n ; i++) {
//                res.add(nums[i]);
//            }
//         }
//
//        int[] arr = new int[res.size()];
//        arr = res.toArray(arr);
//        return arr;


    public int[] shuffle(int[] nums, int n) {
        int res[] = new int[nums.length];
        int[] numsTillMid = new int[n];
        int[] numsTillEnd = new int[nums.length - n];

        for (int i = 0; i < n; i++) {
            numsTillMid[i] = nums[i];
        }
        for (int i = 0; i < nums.length - n; i++) {
            numsTillEnd[i] = nums[n+i];
        }
        int j = 0;
        for (int i = 0; i < numsTillMid.length && i < numsTillEnd.length; i++) {
            res[j++] = numsTillMid[i];
            res[j++] = numsTillEnd[i];
        }
        if (numsTillMid.length > numsTillEnd.length) {
            for (int i = numsTillEnd.length; i < numsTillMid.length; i++) {
                res[j++] = numsTillMid[i];
            }
        } else
        if (numsTillEnd.length > numsTillMid.length) {
            for (int i = numsTillMid.length; i < numsTillEnd.length; i++) {
                res[j++] = numsTillEnd[i];
            }
        }
        return res;
    }
        public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int n = 3;
        Shuffle res = new Shuffle();
        System.out.println(Arrays.toString(res.shuffle(nums, n)));
    }
}
