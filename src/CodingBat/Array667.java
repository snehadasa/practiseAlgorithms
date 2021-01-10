package CodingBat;

public class Array667 {

    //    Given an array of ints, return the number of times that two 6's are next to each other
//    in the array. Also count instances where the second "6" is actually a 7.
//
//
//    array667([6, 6, 2]) → 1
//    array667([6, 6, 2, 6]) → 1
//    array667([6, 7, 2, 6]) → 1
    public int array667(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 6 && (nums[i + 1] == 6 || nums[i+1] == 7)) {
                count += 1;
            }
        }
        return count;
    }
//    public int array667(int[] nums) {
//        int count = 0;
//        // Note: iterate to length-1, so can use i+1 in the loop
//        for (int i=0; i < (nums.length-1); i++) {
//            if (nums[i] == 6) {
//                if (nums[i+1] == 6 || nums[i+1] == 7) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        int[] n1 = {6, 6, 2};
        int[] n2 = {6, 6, 2, 6};
        int[] n3 = {6, 7, 6, 6};

        Array667 res = new Array667();
        System.out.println(res.array667(n1));
        System.out.println(res.array667(n2));
        System.out.println(res.array667(n3));
    }
}
