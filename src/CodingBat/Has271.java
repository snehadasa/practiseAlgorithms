package CodingBat;

import java.util.Arrays;
import java.util.HashMap;

public class Has271 {
//    Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value,
//    followed by the value plus 5, followed by the value minus 1. Additionally the 271 counts
//    even if the "1" differs by 2 or less from the correct value.
//
//
//    has271([1, 2, 7, 1]) → true
//    has271([1, 2, 8, 1]) → false
//    has271([2, 7, 1]) → true
    public boolean has271(int[] nums) {
        int n1 = 0, n2 = 0, n3 = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            n1 = nums[i];
            n2 = nums[i]+5;
            n3 = nums[i]-1;
            if (nums[i] == n1 && nums[i+1] == n2 && (Math.abs(nums[i+2] - n3) <= 2)) {
                return true;
            }
        }

        return false;

    }

//    public boolean has271(int[] nums) {
//        // Iterate < length-2, so can use i+1 and i+2 in the loop.
//        // Return true immediately when seeing 271.
//        for (int i=0; i < (nums.length-2); i++) {
//            int val = nums[i];
//            if (nums[i+1] == (val+5) &&              // the "7" check
//                    Math.abs(nums[i+2] - (val-1)) <= 2) {  // the "1" check
//                return true;
//            }
//        }
//
//        // If we get here ... none found.
//        return false;
//    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 7, 1};
        int[] num2 = {1, 2, 8, 1};
        int[] num3 = {2, 7, 1};
        int[] num4 = {3, 8, 2};
        int[] num5 = {2, 7, -1};
        Has271 res = new Has271();
        System.out.println(res.has271(num1));
        System.out.println(res.has271(num2));
        System.out.println(res.has271(num3));
        System.out.println(res.has271(num4));
        System.out.println(res.has271(num5));
    }
}
