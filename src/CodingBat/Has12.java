package CodingBat;

public class Has12 {

//    Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array.
//
//
//            has12([1, 3, 2]) → true
//    has12([3, 1, 2]) → true
//    has12([3, 1, 4, 5, 2]) → true

    public boolean has12(int[] nums) {
        int pos1 = -1, pos2 = -1;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                pos1 = Math.max(pos1, nums[i]);
            }

            if (nums[i] == 2) {
                if (pos2 == -1) {
                    pos2 = i;
                }
            }


        }
        return pos1 >= 0 && pos2 >= 0 && pos1 < pos2;

        //Method2
//        boolean flag1 = false;
//        boolean flag2 = false;
//        int pos1 = 0, pos2 = 0;
//        for (int i = 0; i < nums.length; i++) {
//
//            if (nums[i] == 1) {
//                flag1 = true;
//                //pos1 = Math.max(pos1, nums[i]);
//            }
//
//            if (nums[i] == 2 && flag1) {
//                flag2 = true;
//                //pos1 = Math.max(pos2, nums[i]);
//            }
//
//
//        }
//        return (flag2);
    }

    public static void main(String[] args) {
        int[] n1 = {3, 1, 4, 2, 6};
        int[] n2 = {2, 1, 4, 1, 6};
        int[] n3 = {2, 1, 3};
        Has12 res = new Has12();
        System.out.println(res.has12(n1));
        System.out.println(res.has12(n2));
        System.out.println(res.has12(n3));
    }
}
