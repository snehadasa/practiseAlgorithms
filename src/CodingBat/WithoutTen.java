package CodingBat;

import java.util.Arrays;

public class WithoutTen {

    //    Return a version of the given array where all the 10's have been removed. The remaining
//    elements should shift left towards the start of the array as needed, and the empty spaces a the
//    end of the array should be 0. So {1, 10, 10, 2} yields {1, 2, 0, 0}. You may modify
//    and return the given array or make a new array.
//
//
//    withoutTen([1, 10, 10, 2]) → [1, 2, 0, 0]
//    withoutTen([10, 2, 10]) → [2, 0, 0]
//    withoutTen([1, 99, 10]) → [1, 99, 0]
    public int[] withoutTen(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 10)
                count++;
        }
        int[] newA = new int[nums.length];
        for (int numsarrayindex = 0, newarrayindex = 0; numsarrayindex < nums.length && newarrayindex <= count; numsarrayindex++) {
            if (nums[numsarrayindex] != 10) {
                newA[newarrayindex] = nums[numsarrayindex];
                newarrayindex++;
            }
        }

        int index = count; //to start from (count-1) element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 10) {
                newA[index] = 0;
            }
        }
        return newA;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 10, 10, 2};
        int[] n2 = {10, 2, 10};
        int[] n3 = {1, 99, 10};
        WithoutTen res = new WithoutTen();
        System.out.println(Arrays.toString(res.withoutTen(n1)));
        System.out.println(Arrays.toString(res.withoutTen(n2)));
        System.out.println(Arrays.toString(res.withoutTen(n3)));
    }
}
