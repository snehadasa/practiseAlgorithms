package CodingBat;

public class HaveThree {

//    Given an array of ints, return true if the value 3 appears in the array exactly 3 times, and no 3's are next to each other.
//
//
//    haveThree([3, 1, 3, 1, 3]) → true
//    haveThree([3, 1, 3, 3]) → false
//    haveThree([3, 4, 3, 3, 4]) → false

    public boolean haveThree(int[] nums) {
        int count = 0;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == 3) {
                count += 1;
                i++;
            }
        }
        if (count == 3)
            return true;
        return false;

    }

    public static void main(String[] args) {
        int[] n1 = {3, 1, 3, 1, 3};
        int[] n2 = {3, 1, 3, 3};
        int[] n3 = {3, 4, 3, 3, 4};
        HaveThree res = new HaveThree();
        System.out.println(res.haveThree(n1));
        System.out.println(res.haveThree(n2));
        System.out.println(res.haveThree(n3));
    }
}
