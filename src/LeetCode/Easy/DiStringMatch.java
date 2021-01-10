package LeetCode.Easy;

import java.util.Arrays;

public class DiStringMatch {
//    Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
//
//            Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
//
//    If S[i] == "I", then A[i] < A[i+1]
//    If S[i] == "D", then A[i] > A[i+1]
//
//
//    Example 1:
//
//    Input: "IDID"
//    Output: [0,4,1,3,2]
//    Example 2:
//
//    Input: "III"
//    Output: [0,1,2,3]
//    Example 3:
//
//    Input: "DDI"
//    Output: [3,2,0,1]
//
//
//    Note:
//
//            1 <= S.length <= 10000
//    S only contains characters "I" or "D".

    /**
     * The given string only contains upper case characters 'D' and 'I'.
     * Return an array A filled with numbers in any permutation, but satisfying the following two conditions
     *
     * If S[i] == "I", then A[i] < A[i+1]
     * If S[i] == "D", then A[i] > A[i+1]
     *
     * Since the array A always starts with 0, the length of output array differs by 1 compared to the length of the given input String S.
     *
     * Examples: (I used ----> for better alignment )
     *
     * Input: "IDID"
     * Output: [0,4,1,3,2]
     * Another possible output : [0,3,1,4,2]
     * --------------------------> I D I D
     *
     * Input: "DDI"
     * Output: [3,2,0,1]
     * -------> DD I
     * Remember If S[i] == 'I', then A[i] < A[i+1]. So 3rd element in Array A should be less than 4th element of Array A.
     *
     * Input-------------->: "I I D"
     * Output------------>: 123 0
     * Alternate output is : 013 2. Remember if the character is D, its corresponding index in output array A should satisfy A[i] > A[i+1]
     */

    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] result = new int[N+1];
        int lo = 0, hi = N;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                result[i] += lo++;
            }
            if (S.charAt(i) == 'D') {
                result[i] += hi--;
            }
        }
        result[N] = lo;
        return result;
    }

    public static void main(String[] args) {
        String S = "IDID";
        DiStringMatch res = new DiStringMatch();
        System.out.println(Arrays.toString(res.diStringMatch(S)));
    }
}
