package LeetCode.Easy;

import java.util.ArrayList;

public class PeakIndexInMountainArray {
//    Let's call an array arr a mountain if the following properties hold:
//
//    arr.length >= 3
//    There exists some i with 0 < i < arr.length - 1 such that:
//    arr[0] < arr[1] < ... arr[i-1] < arr[i]
//    arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//    Given an integer array arr that is guaranteed to be a mountain, return any i such that
//        arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
//
//
//
//    Example 1:
//
//    Input: arr = [0,1,0]
//    Output: 1
//    Example 2:
//
//    Input: arr = [0,2,1,0]
//    Output: 1
//    Example 3:
//
//    Input: arr = [0,10,5,2]
//    Output: 1
//    Example 4:
//
//    Input: arr = [3,4,5,1]
//    Output: 2
//    Example 5:
//
//    Input: arr = [24,69,100,99,79,78,67,36,26,19]
//    Output: 2
//
//
//    Constraints:
//
//            3 <= arr.length <= 104
//            0 <= arr[i] <= 106
//    arr is guaranteed to be a mountain array.

    public int peakIndexInMountainArray(int[] arr) {
        boolean flag = false;
        int pos = 0;

        if (arr.length < 3) {
            return 0;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i+1]) {
                flag = true;
            }

            if (flag) {
                pos = i;
            }
            if (arr[i] > arr[i+1]) {
                flag = false;
            }

        }
        return pos;
    }

    public int peakIndexInMountainArray1(int[] A) {
        int i = 0;
        while (A[i] < A[i+1]) i++;
        return i;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,0};
        int[] arr2 = {24,69,100,99,79,78,67,36,26,19};
        PeakIndexInMountainArray res = new PeakIndexInMountainArray();
        System.out.println(res.peakIndexInMountainArray(arr));
        System.out.println(res.peakIndexInMountainArray(arr2));
    }
}
