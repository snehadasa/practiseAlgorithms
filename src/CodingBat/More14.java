package CodingBat;

public class More14 {
//    Given an array of ints, return true if the number of 1's is greater than the number of 4's
//
//
//    more14([1, 4, 1]) → true
//    more14([1, 4, 1, 4]) → false
//    more14([1, 1]) → true

    public boolean more14(int[] nums) {
        int count1 = 0, count4 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                count1 += 1;
            else if (nums[i] == 4)
                count4 += 1;
        }
        if (count1 > count4)
            return true;
        return false;

    }

    public static void main(String[] args) {
        int[] n1 = {1, 4, 1};
        int[] n2 = {1, 4, 1, 4};
        int[] n3 = {1, 1};
        More14 res = new More14();
        System.out.println(res.more14(n1));
        System.out.println(res.more14(n2));
        System.out.println(res.more14(n3));
    }
}
