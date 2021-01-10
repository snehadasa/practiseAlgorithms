package CodingBat;

import java.util.Arrays;

public class CenteredAverage {

//    Return the "centered" average of an array of ints, which we'll say is
//    the mean average of the values, except ignoring the largest and smallest
//    values in the array. If there are multiple copies of the smallest value, ignore
//    just one copy, and likewise for the largest value. Use int division to produce the
//    final average. You may assume that the array is length 3 or more.
//
//
//    centeredAverage([1, 2, 3, 4, 100]) → 3
//    centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
//    centeredAverage([-10, -4, -2, -4, -2, 0]) → -3

    public int centeredAverage(int[] nums) {
        int avg = 0, sum = 0, sum1 = 0;
        //int n = 0;
        int maxV = 0, minV = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxV = Arrays.stream(nums).max().getAsInt();
            minV = Arrays.stream(nums).min().getAsInt();
            sum1 = sum - maxV - minV;

            //n += i;

        }
        avg = (sum1 / (nums.length - 2));
        return avg;
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
