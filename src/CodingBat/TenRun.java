package CodingBat;

import java.util.Arrays;

public class TenRun {

    //    For each multiple of 10 in the given array, change all the values following it to be that
//    multiple of 10, until encountering another multiple of 10.
//    So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
//
//
//    tenRun([2, 10, 3, 4, 20, 5]) → [2, 10, 10, 10, 20, 20]
//    tenRun([10, 1, 20, 2]) → [10, 10, 20, 20]
//    tenRun([10, 1, 9, 20]) → [10, 10, 10, 20]
    public int[] tenRun(int[] nums) {
        int rem = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 10 == 0) {
                rem = (nums[i] / 10);
                flag = true;
            }
            if (flag)
                nums[i] = rem * 10;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] n1 = {2, 10, 3, 4, 20, 5};
        int[] n2 = {10, 1, 20, 2};
        int[] n3 = {10, 1, 9, 20};
        TenRun res = new TenRun();
        System.out.println(Arrays.toString(res.tenRun(n1)));
        System.out.println(Arrays.toString(res.tenRun(n2)));
        System.out.println(Arrays.toString(res.tenRun(n3)));
    }

}
