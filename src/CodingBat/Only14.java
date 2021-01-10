package CodingBat;

public class Only14 {

//    Given an array of ints, return true if every element is a 1 or a 4.
//
//
//    only14([1, 4, 1, 4]) → true
//    only14([1, 4, 2, 4]) → false
//    only14([1, 1]) → true

    public boolean only14(int[] nums) {
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] != 1 && nums[i] != 4)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] n1 = {1, 4, 2};
        int[] n2 = {1, 4, 1, 4};
        int[] n3 = {1, 1};
        Only14 res = new Only14();
        System.out.println(res.only14(n1));
        System.out.println(res.only14(n2));
        System.out.println(res.only14(n3));
    }
}
