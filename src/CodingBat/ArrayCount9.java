package CodingBat;

public class ArrayCount9 {

//    Given an array of ints, return the number of 9's in the array.
//
//
//    arrayCount9([1, 2, 9]) → 1
//    arrayCount9([1, 9, 9]) → 2
//    arrayCount9([1, 9, 9, 3, 9]) → 3

    public int arrayCount9(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 9)
                count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 9};
        int[] num2 = {1, 9, 9};
        int[] num3 = {1, 9, 9, 3, 9};
        ArrayCount9 res = new ArrayCount9();
        System.out.println(res.arrayCount9(num1));
        System.out.println(res.arrayCount9(num2));
        System.out.println(res.arrayCount9(num3));
    }
}
