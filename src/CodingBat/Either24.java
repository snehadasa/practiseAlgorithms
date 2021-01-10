package CodingBat;

public class Either24 {

//    Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.
//
//
//            either24([1, 2, 2]) → true
//    either24([4, 4, 1]) → true
//    either24([4, 4, 1, 2, 2]) → false

    public boolean either24(int[] nums) {
        boolean flag2 = false;
        boolean flag4 = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2)
                flag2 = true;
            else if (nums[i] == 4 && nums[i + 1] == 4)
                flag4 = true;
        }
        if ((flag2 && !flag4) || (!flag2 && flag4))
            return true;

        return false;
    }

    public static void main(String[] args) {
        int[] n1 = {3, 5, 9};
        int[] n2 = {1, 2, 3, 4, 4};
        int[] n3 = {2, 2, 4, 4};

        Either24 res = new Either24();
        System.out.println(res.either24(n1));
        System.out.println(res.either24(n2));
        System.out.println(res.either24(n3));
    }
}
