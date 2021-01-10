package CodingBat;

public class ModThree {
//    Given an array of ints, return true if the array contains either 3 even or 3 odd values all next to each other.
//
//
//            modThree([2, 1, 3, 5]) → true
//    modThree([2, 1, 2, 5]) → false
//    modThree([2, 4, 2, 5]) → true

    public boolean modThree(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
           if ((nums[i] % 2 == 0) && (nums[i+1] % 2 == 0) && (nums[i+2] % 2 == 0)) {
               return true;
           }
           else if ((nums[i] % 2 == 1) && (nums[i+1] % 2 == 1) && (nums[i+2] % 2 == 1)) {
               return true;
           }
        }
        return false;
    }

//    public boolean modThree(int[] nums)
//    {
//        for(int i = 0; i < nums.length - 2; i++)
//        {
//            if(nums[i] % 2 == nums[i+1] % 2 && nums[i] % 2 == nums[i+2] % 2)
//                return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[] n1 = {2, 1, 3, 5};
        int[] n2 = {2, 1, 2, 5};
        int[] n3 = {2, 4, 2, 5};
        ModThree res = new ModThree();
        System.out.println(res.modThree(n1));
        System.out.println(res.modThree(n2));
        System.out.println(res.modThree(n3));
    }
}
