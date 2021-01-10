package CodingBat;

import java.util.Arrays;

public class ZeroFront {

//    Return an array that contains the exact same numbers as the given array, but rearranged
//    so that all the zeros are grouped at the start of the array. The order of the non-zero numbers does not
//    matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. You may modify and return the given array or make a new array.
//
//
//            zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
//    zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
//    zeroFront([1, 0]) → [0, 1]

    public int[] zeroFront(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count++;
        }
        //for initial zeros
        int[] newA = new int[nums.length];
        for (int j = 0; j < count; j++) {
            newA[j] = 0;
        }
        //for remaining numbers
        int index = count; //to start from (count-1) element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                newA[index] = nums[i];
                index++;
            }
        }
        return newA;

    }

//    public int[] zeroFront(int[] nums) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                count++;
//            }
//        }
//        int[] newA = new int[nums.length];
//        for (int addingzero = 0; addingzero < count; addingzero++) {
//            newA[addingzero] = 0;
//        }
//        int index = count;
//        for (int addingremaining = 0; addingremaining < nums.length;
//             addingremaining++) {
//            if (nums[addingremaining] != 0) {
//                newA[index] = nums[addingremaining];
//                index++;
//            }
//        }
//        return newA;
//    }

    public static void main(String[] args) {
        int[] n1 = {1, 0, 0, 1};
        int[] n2 = {0, 1, 1, 0, 1};
        int[] n3 = {1, 0};
        ZeroFront res = new ZeroFront();
        System.out.println(Arrays.toString(res.zeroFront(n1)));
        System.out.println(Arrays.toString(res.zeroFront(n2)));
        System.out.println(Arrays.toString(res.zeroFront(n3)));
    }

}
