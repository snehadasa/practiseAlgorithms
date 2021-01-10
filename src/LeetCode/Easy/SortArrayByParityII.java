package LeetCode.Easy;

import java.util.Arrays;

public class SortArrayByParityII {
    //    Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
//
//    Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
//
//    You may return any answer array that satisfies this condition.
//
//
//
//            Example 1:
//
//    Input: [4,2,5,7]
//    Output: [4,5,2,7]
//    Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
//
//
//            Note:
//
//            2 <= A.length <= 20000
//    A.length % 2 == 0
//            0 <= A[i] <= 1000
    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if ((A[i] % 2 == 0 && i % 2 == 0) || (A[i] % 2 == 1 && i % 2 == 1) ) {
                continue;
            }
            for (int j = i+1; j < A.length; j++) {
                if (A[j] % 2 == 0 && i % 2 == 0) {
                    swapElements(A, i, j);
                    break;
                } else
                if (A[j] % 2 == 1 && i % 2 == 1) {
                    swapElements(A, i, j);
                    break;
                }
            }
        }
        return A;
    }

    private void swapElements(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {4, 2, 5, 7};
        int[] A1 = {4, 1, 2, 1};
        int[] A2 = {3, 1, 4, 2};
        SortArrayByParityII res = new SortArrayByParityII();
        System.out.println(Arrays.toString(res.sortArrayByParityII(A)));
        System.out.println(Arrays.toString(res.sortArrayByParityII(A1)));
        System.out.println(Arrays.toString(res.sortArrayByParityII(A2)));
    }
}
