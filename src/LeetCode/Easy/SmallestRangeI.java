package LeetCode.Easy;

import java.util.*;
import java.util.stream.IntStream;

public class SmallestRangeI {
    //    Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
//
//    After this process, we have some array B.
//
//    Return the smallest possible difference between the maximum value of B and the minimum value of B.
//
//
//
//            Example 1:
//
//    Input: A = [1], K = 0
//    Output: 0
//    Explanation: B = [1]
//    Example 2:
//
//    Input: A = [0,10], K = 2
//    Output: 6
//    Explanation: B = [2,8]
//    Example 3:
//
//    Input: A = [1,3,6], K = 3
//    Output: 0
//    Explanation: B = [3,3,3] or B = [4,4,4]
//
//
//    Note:
//
//            1 <= A.length <= 10000
//            0 <= A[i] <= 10000
//            0 <= K <= 10000
    public int smallestRangeI(int[] A, int K) {
        int[] B = new int[A.length];
        List<Integer> diff = new ArrayList<>();

        Arrays.sort(A);
        for (int i = 0; i < A.length/2 - 1; i++) {
            if (A[i] == K) {
                B[i] = A[i];
            } else
                B[i] = A[i] + K;
        }
        for (int i = A.length - 1; i >= A.length/2; i--) {
            if (A[i] == K) {
                B[i] = A[i];
            } else
                B[i] = Math.abs(A[i] - K);
        }
        Arrays.sort(B);
        int min = 0;
        for (int i = 0; i < B.length - 1; i++) {
            diff.add(B[i+1] - B[i]);
        }
         min = Collections.min(diff);

        return min;
    }

    public static void main(String[] args) {
        SmallestRangeI res = new SmallestRangeI();
        int[] A1 = {0,10}, A2 = {1,3,6};
        int k1 = 2, k2 = 3;
        System.out.println(res.smallestRangeI(A1, k1));
        System.out.println(res.smallestRangeI(A2, k2));
        //System.out.println(Arrays.toString(res.smallestRangeI(A, k)));
    }
}
