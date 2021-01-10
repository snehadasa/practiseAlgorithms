package CodingBat;

public class ArrayFront9 {
//    Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.
//
//
//    arrayFront9([1, 2, 9, 3, 4]) → true
//    arrayFront9([1, 2, 3, 4, 9]) → false
//    arrayFront9([1, 2, 3, 4, 5]) → false

    public boolean arrayFront9(int[] nums) {
        for (int i = 0; i < Math.min(4, nums.length); i++) {
            if (nums[i] == 9) {
                return true;
            }
        }
        return false;
    }

//    public boolean arrayFront9(int[] nums) {
//        for (int i = 0; i < nums.length && i < 4; i++) {
//            if (nums[i] == 9) {
//                return true;
//            }
//        }
//        return false;
//    }


    public static void main(String[] args) {
        int[] num1 = {1, 2, 9};
        int[] num2 = {1, 9, 9};
        int[] num3 = {1, 9, 9, 3, 9};
        ArrayFront9 res = new ArrayFront9();
        System.out.println(res.arrayFront9(num1));
        System.out.println(res.arrayFront9(num2));
        System.out.println(res.arrayFront9(num3));
    }
}
