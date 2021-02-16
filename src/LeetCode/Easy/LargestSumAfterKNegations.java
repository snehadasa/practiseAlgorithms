package LeetCode.Easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LargestSumAfterKNegations {
//    Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i]
//    with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)
//
//    Return the largest possible sum of the array after modifying it in this way.
//
//
//
//            Example 1:
//
//    Input: A = [4,2,3], K = 1
//    Output: 5
//    Explanation: Choose indices (1,) and A becomes [4,-2,3].
//    Example 2:
//
//    Input: A = [3,-1,0,2], K = 3
//    Output: 6
//    Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
//    Example 3:
//
//    Input: A = [2,-3,-1,5,-4], K = 2
//    Output: 13
//    Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
//
//
//    Note:
//
//            1 <= A.length <= 10000
//            1 <= K <= 10000
//            -100 <= A[i] <= 100

    public int largestSumAfterKNegations(int[] A, int K) {
       boolean isNegative = false;
       int sum = 0;
       Arrays.sort(A);
       int i = 0;
       for (i = 0; i < K; i++) {
           if (A[i] <= 0) {
               A[i] = -A[i];
               isNegative = true;
           } else {
               isNegative = false;
               break;
           }
       }

       if (isNegative) {
           for (int j = 0; j < A.length; j++) {
               sum += A[j];
           }
       } else {
           K = K - i;
           Arrays.sort(A);
           for (int j = 0; j < A.length; j++) {
               sum += A[j];
           }
           if (K % 2 == 1) {
               sum = sum - 2*A[0];
           }
       }
       return sum;
    }

    public int largestSumAfterKNegations1(int[] A, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int elementInA : A) {
            queue.offer(elementInA);
        }

        while (K > 0) {
            queue.offer(-queue.poll());
            K--;
        }
        return queue.stream().mapToInt(i -> i).sum();
    }
    public static void main(String[] args) {
        int[] arr1 = {4,2,3}, arr2 = {3,-1,0,2};
        int K1 = 1, K2 = 3;
        LargestSumAfterKNegations res = new LargestSumAfterKNegations();
        //System.out.println(res.largestSumAfterKNegations(arr1, K1));
        System.out.println(res.largestSumAfterKNegations(arr2, K2));
    }
}
