package CodingBat;

import java.util.Arrays;

public class NotAlone {
//    We'll say that an element in an array is "alone" if there are values before and
//    after it, and those values are different from it. Return a version of the given array
//    where every instance of the given value which is alone is replaced by
//    whichever value to its left or right is larger.
//
//
//    notAlone([1, 2, 3], 2) → [1, 3, 3]
//    notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 2]
//    notAlone([3, 4], 3) → [3, 4]

    public int[] notAlone(int[] nums, int val) {
       // boolean flag = false;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == val && (nums[i - 1] != val && nums[i + 1] != val)) {
                //flag = true;
                if (nums[i + 1] > nums[i - 1]) {
                    nums[i] = nums[i + 1];
                } else
                    nums[i] = nums[i - 1];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2, 3};
        int[] n2 = {1, 2, 3, 2, 5, 2};
        int[] n3 = {3, 4};
        int val1 = 2, val2 = 2, val3 = 3;
        NotAlone res = new NotAlone();
        System.out.println(Arrays.toString(res.notAlone(n1, val1)));
        System.out.println(Arrays.toString(res.notAlone(n2, val2)));
        System.out.println(Arrays.toString(res.notAlone(n3, val3)));
    }
}
