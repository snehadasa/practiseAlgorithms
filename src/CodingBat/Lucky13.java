package CodingBat;

import java.util.Arrays;

public class Lucky13 {
    //    Given an array of ints, return true if the array contains no 1's and no 3's.
//
//
//            lucky13([0, 2, 4]) → true
//    lucky13([1, 2, 3]) → false
//    lucky13([1, 2, 4]) → false
    public boolean lucky13(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 || nums[i] == 3)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] n1 = {0, 2, 4};
        int[] n2 = {1, 2, 3};
        int[] n3 = {1, 2, 4};
        Lucky13 res = new Lucky13();
        System.out.println(res.lucky13(n1));
        System.out.println(res.lucky13(n2));
        System.out.println(res.lucky13(n3));
    }

}
