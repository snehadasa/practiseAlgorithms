package CodingBat;

import java.util.Arrays;

public class ShiftLeft {

    //    Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}.
//    You may modify and return the given array, or return a new array.
//
//
//            shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
//    shiftLeft([1, 2]) → [2, 1]
//    shiftLeft([1]) → [1]
    public int[] shiftLeft(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] n1 = {6, 2, 5, 3};
        int[] n2 = {1, 2};
        int[] n3 = {1};
        ShiftLeft res = new ShiftLeft();
        System.out.println(Arrays.toString(res.shiftLeft(n1)));
        System.out.println(Arrays.toString(res.shiftLeft(n2)));
        System.out.println(Arrays.toString(res.shiftLeft(n3)));
    }
}
