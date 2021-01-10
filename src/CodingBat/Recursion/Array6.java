package CodingBat.Recursion;

public class Array6 {

//    Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering
//    only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move
//    down the array. The initial call will pass in index as 0.
//
//
//    array6([1, 6, 4], 0) → true
//    array6([1, 4], 0) → false
//    array6([6], 0) → true

    public boolean array6(int[] nums, int index) {
        if (index == nums.length) {
            return false;
        }
        if (nums[index] == 6) {
            return true;
        }
        return array6(nums, index+1);
    }

    public static void main(String[] args) {
        int[] n1 = {1, 6, 6};
        int index1 = 0;
        Array6 res = new Array6();
        System.out.println(res.array6(n1, index1));
    }
}
