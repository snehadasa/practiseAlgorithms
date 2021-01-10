package CodingBat;

public class Sum28 {

    //    Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
//
//
//    sum28([2, 3, 2, 2, 4, 2]) → true
//    sum28([2, 3, 2, 2, 4, 2, 2]) → false
//    sum28([1, 2, 3, 4]) → false
    public boolean sum28(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                //count += i;
                sum += nums[i];
            }
        }
        if (sum == 8)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] n1 = {2, 3, 2, 2, 4, 2};
        int[] n2 = {2, 3, 2, 2, 4, 2, 2};
        int[] n3 = {1, 2, 3, 4};
        Sum28 res = new Sum28();
        System.out.println(res.sum28(n1));
        System.out.println(res.sum28(n2));
        System.out.println(res.sum28(n3));
    }

}
