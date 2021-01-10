package CodingBat;

import java.util.Arrays;

public class Post4 {

//    Given a non-empty array of ints, return a new array containing the elements from the original
//    array that come after the last 4 in the original array. The original array will contain at least
//    one 4. Note that it is valid in java to create an array of length 0.
//
//
//    post4([2, 4, 1, 2]) → [1, 2]
//    post4([4, 1, 4, 2]) → [2]
//    post4([4, 4, 1, 2, 3]) → [1, 2, 3]

    public int[] post4(int[] nums) {
        //boolean flag = true;
//        int count = 0;
//        for (int i = nums.length - 1; i > 0; i--) {
//            if (nums[i] == 4)
//                break;
//            count++;
//        }
//        int newA[] = new int[count];
//        for (int i = 0; i < count; i++) {
//            newA[i] = nums[nums.length  - count + i];
//        }
//        return newA;
        int lastIndexof4 = nums.length;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == 4) {
                lastIndexof4 = i;
                break;
            }
        }
        int newA[] = new int[nums.length - lastIndexof4 - 1];
        for (int i = lastIndexof4 + 1; i < nums.length; i++) {
            newA[i-(lastIndexof4+1)] = nums[i];
        }
        return newA;


    }

    public static void main(String[] args) {
        int[] n1 = {2, 4, 1, 2};
        int[] n2 = {4, 1, 4, 2};
        int[] n3 = {4, 4, 1, 2, 3};
        Post4 res = new Post4();
        System.out.println(Arrays.toString(res.post4(n1)));
        System.out.println(Arrays.toString(res.post4(n2)));
        System.out.println(Arrays.toString(res.post4(n3)));
    }
}
