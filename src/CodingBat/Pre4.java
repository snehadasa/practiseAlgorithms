package CodingBat;

import java.util.Arrays;

public class Pre4 {

//    Given a non-empty array of ints, return a new array containing the elements from the
//    original array that come before the first 4 in the original array. The original array will
//    contain at least one 4. Note that it is valid in java to create an array of length 0.
//
//
//    pre4([1, 2, 4, 1]) → [1, 2]
//    pre4([3, 1, 4]) → [3, 1]
//    pre4([1, 4, 4]) → [1]

    public int[] pre4(int[] nums) {
        boolean flag = true;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == 4) {
                flag = false;
            }
            if (flag)
                count++;
        }
        int newA[] = new int[count];
        for (int i = 0; i < count; i++) {
            newA[i] = nums[i];
        }
        return newA;
    }

//    public int[] pre4(int[] nums) {
//        int count = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//
//            if (nums[i] == 4) {
//                break;
//            }
//            count++;
//        }
//        int newA[] = new int[count];
//
//        for (int i = 0; i < count; i++) {
//            newA[i] = nums[i];
//        }
//
//        return newA;
//    }

    public static void main(String[] args) {
        int[] n1 = {1, 2, 4, 1};
        int[] n2 = {3, 1, 4};
        int[] n3 = {1, 4, 4};
        Pre4 res = new Pre4();
        System.out.println(Arrays.toString(res.pre4(n1)));
        System.out.println(Arrays.toString(res.pre4(n2)));
        System.out.println(Arrays.toString(res.pre4(n3)));
    }
}
