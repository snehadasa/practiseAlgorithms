package CodingBat;

public class Has22 {

//    Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
//
//
//            has22([1, 2, 2]) → true
//    has22([1, 2, 1, 2]) → false
//    has22([2, 1, 2]) → false

    public boolean has22(int[] nums) {
        // int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i+1] == 2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2, 3, 4, 100};
        int[] n2 = {1, 1, 5, 5, 10, 8, 7};
        int[] n3 = {-10, -4, -2, -4, -2, 0};
        CenteredAverage res = new CenteredAverage();
        System.out.println(res.centeredAverage(n1));
        System.out.println(res.centeredAverage(n2));
        System.out.println(res.centeredAverage(n3));
    }
}
