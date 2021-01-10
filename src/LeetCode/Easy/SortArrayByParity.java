package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortArrayByParity {
//    Given an array A of non-negative integers, return an array consisting of all the even elements of A,
//    followed by all the odd elements of A.
//
//    You may return any answer array that satisfies this condition.
//
//
//
//            Example 1:
//
//    Input: [3,1,2,4]
//    Output: [2,4,3,1]
//    The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

    public int[] sortArrayByParity1(int[] A) {
        int countO = 0, countE = 0;
        for (int iterator:A) {
            if (iterator%2 == 0) {
                countE++;
            }
            if (iterator%2 == 1) {
                countO++;
            }
        }
        int[] newEO = new int[A.length];

        for (int i = 0, j = 0; i < A.length; i++) {
            if (A[i] %2 == 0) {
                newEO[j++] = A[i];
            }
        }
        for (int i = 0, j = countE; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                newEO[j++] = A[i];
            }
        }
        return newEO;
    }

    public int[] sortArrayByParity(int[] A) {
        int[] newEO = new int[A.length];

        for (int i = 0, j = 0, k = A.length - 1; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                newEO[j++] = A[i];
            }
            if (A[i] % 2 == 1) {
                newEO[k--] = A[i];
            }
        }
        return newEO;
    }

    class SortEvenOdd implements Comparator<Integer>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Integer a, Integer b)
        {
            if (a%2 == 0 & b%2 == 1) {
                return -1;
            } else if (a%2 == 1 & b%2 == 0) {
                return +1;
            } else {
                return 0;
            }
        }
    }

//    public int[] sortArrayByParity1(int[] A) {
//        Collections.sort(A, SortEvenOdd);
//    }


        public static void main(String[] args) {
        int[] A = {3,1,2,4};
        SortArrayByParity res = new SortArrayByParity();
        System.out.println(Arrays.toString(res.sortArrayByParity(A)));
    }
}
