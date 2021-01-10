package CodingBat;

import java.util.Arrays;

public class Fix34 {

//    Return an array that contains exactly the same numbers as the given array, but rearranged so that every 3 is
//    immediately followed by a 4. Do not move the 3's, but every other number may move. The array contains the same
//    number of 3's and 4's, every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
//
//
//    fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
//    fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
//    fix34([3, 2, 2, 4]) → [3, 4, 2, 2]

    public int[] fix34(int[] nums) {
        //int[] newA = new int[nums.length];
        int pos = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 4) {
                pos = i;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 3) {
                if (nums[i+1] != 4) {
                    int temp = nums[pos];
                    nums[pos] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 3, 1, 4};
        int[] n2 = {1, 3, 1, 4, 4, 3, 1};
        int[] n3 = {3, 2, 2, 4};
        Fix34 res = new Fix34();
        System.out.println(Arrays.toString(res.fix34(n1)));
        System.out.println(Arrays.toString(res.fix34(n2)));
        System.out.println(Arrays.toString(res.fix34(n3)));
    }
}
