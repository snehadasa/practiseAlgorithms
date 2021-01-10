package LeetCode.Easy;

import java.util.*;

public class SumOddLengthSubarrays {
//    Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
//
//    A subarray is a contiguous subsequence of the array.
//
//    Return the sum of all odd-length subarrays of arr.
//
//
//
//    Example 1:
//
//    Input: arr = [1,4,2,5,3]
//    Output: 58
//    Explanation: The odd-length subarrays of arr and their sums are:
//            [1] = 1
//            [4] = 4
//            [2] = 2
//            [5] = 5
//            [3] = 3
//            [1,4,2] = 7
//            [4,2,5] = 11
//            [2,5,3] = 10
//            [1,4,2,5,3] = 15
//    If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
//    Example 2:
//
//    Input: arr = [1,2]
//    Output: 3
//    Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
//    Example 3:
//
//    Input: arr = [10,11,12]
//    Output: 66
//
//
//    Constraints:
//
//            1 <= arr.length <= 100
//            1 <= arr[i] <= 1000

    public int sumOddLengthSubarrays1(int[] arr) {
        int sum = 0;
        ArrayList<Integer> arrA = new ArrayList<Integer>(arr.length);
        for (int i: arr) {
            arrA.add(i);
        }
        List<Integer> subArr = new ArrayList<>();
        for (int i = 0; i < arrA.size(); i++) {
            subArr = arrA.subList(0, i);

            for (int j = 0; j < subArr.size(); j++) {
                if ((subArr.size())%2 == 1) {
                    sum += subArr.get(j);
                }
            }
        }

        return sum;
    }
    public int sumOddLengthSubarrays2(int[] arr) {
        int sum = 0;
        for (int size = 1 ; size <= arr.length; size += 2) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j < i + size && i + size <= arr.length; j++) {
                    sum += arr[j];
                }
            }
        }
        return sum;
    }
    public int sumOddLengthSubarrays3(int[] arr) {
        int sum = 0;
        if (arr.length < 1) {
            return 0;
        }

        int []cumulativeSum = new int[arr.length];
        cumulativeSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cumulativeSum[i] = cumulativeSum[i-1] + arr[i];
        }

        for (int size = 1; size <= arr.length; size += 2) {
            for (int i = 0; i < arr.length && i + size - 1 < arr.length; i++) {
                sum += (cumulativeSum[i + size-1] - (i == 0 ? 0 : cumulativeSum[i - 1]));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        SumOddLengthSubarrays res = new SumOddLengthSubarrays();
        System.out.println(res.sumOddLengthSubarrays3(arr));
    }

}
