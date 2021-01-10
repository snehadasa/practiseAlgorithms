package CodingBat;

public class IsEverywhere {
    //    We'll say that a value is "everywhere" in an array if for every pair of adjacent elements
//    in the array, at least one of the pair is that value. Return true if the given value is everywhere in the array.
//
//
//    isEverywhere([1, 2, 1, 3], 1) → true
//    isEverywhere([1, 2, 1, 3], 2) → false
//    isEverywhere([1, 2, 1, 3, 4], 1) → false
    public boolean isEverywhere(int[] nums, int val) {
//        int valCount = 0, count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != val)
//                count += 1;
//            if (nums[i] == val)
//                valCount += 1;
//        }
//        if (count == valCount)
//            return true;
//        return false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != val && nums[i-1] != val)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1, 2, 3, 2, 5};
        int[] nums2 = {1, 2, 1, 3};
        int[] nums3 = {1, 2, 1, 3, 4};

        IsEverywhere res = new IsEverywhere();
        System.out.println(res.isEverywhere(nums1, 2));
        System.out.println(res.isEverywhere(nums2, 1));
        System.out.println(res.isEverywhere(nums3, 4));
    }
}
