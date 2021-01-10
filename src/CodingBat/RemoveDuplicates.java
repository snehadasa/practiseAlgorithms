package CodingBat;

import java.util.Arrays;

public class RemoveDuplicates {
    //sorted array.
    //if unsorted, sort it and then perform thr algo
    public int[] removeDupliates(int[] nums) {
        int[] newA = new int[nums.length];
        if (nums.length <= 1) {
            return null;
        }
        int newAIterator = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                newA[newAIterator] = nums[i];
                newAIterator++;
            }
        }
        newA[newAIterator] = nums[newA.length - 1];
        newAIterator++;

//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = newA[i];
//        }

        return newA;
    }

    public static void main(String[] args) {
        int[] n1 = {2, 2, 2, 4, 4, 6, 7, 7, 8};
        int[] n2 = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        RemoveDuplicates res = new RemoveDuplicates();
        System.out.println(Arrays.toString(res.removeDupliates(n1)));
        System.out.println(Arrays.toString(res.removeDupliates(n2)));
    }
}
