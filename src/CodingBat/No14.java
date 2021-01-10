package CodingBat;

public class No14 {

//    Given an array of ints, return true if it contains no 1's or it contains no 4's.
//
//
//            no14([1, 2, 3]) → true
//    no14([1, 2, 3, 4]) → false
//    no14([2, 3, 4]) → true

    public boolean no14(int[] nums) {
        boolean oneFlag = true;
        boolean fourFlag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                oneFlag = false;
            if (nums[i] == 4)
                fourFlag = false;
        }
        return (oneFlag || fourFlag);

//        if (oneFlag == true || fourFlag == true) {
//            return true;
//        }
//        return false;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2, 3};
        int[] n2 = {1, 2, 3, 4};
        int[] n3 = {2, 3, 4};
        No14 res = new No14();
        System.out.println(res.no14(n1));
        System.out.println(res.no14(n2));
        System.out.println(res.no14(n3));
    }
}
