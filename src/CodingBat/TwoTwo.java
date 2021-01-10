package CodingBat;

import java.nio.channels.FileLock;

public class TwoTwo {

//    Given an array of ints, return true if every 2 that appears in the array is next to another 2.
//
//
//    twoTwo([4, 2, 2, 3]) → true
//    twoTwo([2, 2, 4]) → true
//    twoTwo([2, 2, 4, 2]) → false

    public boolean twoTwo(int[] nums) {
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] == 2) {
                if (!((i < nums.length - 1 && nums[i+1] == 2) || (i > 0 && nums[i-1] == 2))) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] n1 = {4, 2, 2, 3};
        int[] n2 = {2, 2, 4};
        int[] n3 = {2, 2, 4, 2};
        TwoTwo res = new TwoTwo();
        System.out.println(res.twoTwo(n1));
        System.out.println(res.twoTwo(n2));
        System.out.println(res.twoTwo(n3));
    }
}
