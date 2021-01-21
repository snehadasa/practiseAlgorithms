package LeetCode.Easy;

import java.util.Arrays;

public class MoveZeros {
//    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//    Example:
//
//    Input: [0,1,0,3,12]
//    Output: [1,3,12,0,0]
//    Note:
//
//    You must do this in-place without making a copy of the array.
//    Minimize the total number of operations.

    public void moveZeroes1(int[] nums) {
        int count = 0;

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                count++;
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] != 0) {
                i++;
            }
            else if (nums[j] == 0) {
                j--;
            } else {
                swap(nums, i, j);
                i++;
                j--;
            }

        }
    }

    public void moveZeroes2(int[] nums) {
        int countNonZero = 0;
        int posToInsert  = 0;
        for (int num : nums) {
            if (num != 0) {
                countNonZero++;
                nums[posToInsert++] = num;
            }
        }
        for (int i = countNonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12, 9, 8, 0, 3, 6};

        MoveZeros res = new MoveZeros();
        res.moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
