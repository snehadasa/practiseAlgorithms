package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixesDivBy5 {
//    Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number
//    (from most-significant-bit to least-significant-bit.)
//
//    Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
//
//    Example 1:
//
//    Input: [0,1,1]
//    Output: [true,false,false]
//    Explanation:
//    The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible
//    by 5, so answer[0] is true.
//    Example 2:
//
//    Input: [1,1,1]
//    Output: [false,false,false]
//    Example 3:
//
//    Input: [0,1,1,1,1,1]
//    Output: [true,false,false,false,true,false]
//    Example 4:
//
//    Input: [1,1,1,0,1]
//    Output: [false,false,false,false,false]
//
//
//    Note:
//
//            1 <= A.length <= 30000
//    A[i] is 0 or 1

    public int binaryToDecimalConversion(String n) {
        int base = 1;
        int decvalue = 0;
        for (int i = n.length() - 1; i >= 0; i--) {
            if (n.charAt(i) == '1') {
                decvalue += base;
                decvalue = decvalue%10;
            }
            base *= 2;
            base = base%10;
        }
        return decvalue;
    }
    public List<Boolean> prefixesDivBy5(int[] A) {
        String a = Arrays.toString(A);
        String aA[] = a.substring(1, a.length()-1).split(", ");
        List<String> binaryDigi = new ArrayList<>();
        List<Integer> binaryToDecimal = new ArrayList<>();
        List<Boolean> ifDivBy5 = new ArrayList<>();
        String num = "";
        for (int i = 0; i < aA.length; i++) {
            num += aA[i];
            binaryDigi.add(num);
        }

        for (int i = 0; i < binaryDigi.size(); i++) {
            binaryToDecimal.add(binaryToDecimalConversion(binaryDigi.get(i)));
        }
        for (int i = 0; i < binaryToDecimal.size(); i++) {
            int rem = binaryToDecimal.get(i) % 5;
            if (rem == 0 || rem == 5) {
                ifDivBy5.add(true);
            } else
                ifDivBy5.add(false);
        }
        return ifDivBy5;
    }

    public List<Boolean> prefixesDivBy51(int[] A) {
        String a = Arrays.toString(A);
        List<Boolean> ifDivBy5 = new ArrayList<>();
        String num = "";
        for (int i = 0; i < A.length; i++) {
            num += A[i];
            int rem = binaryToDecimalConversion(num) % 5;
            ifDivBy5.add(rem == 0);
        }
        return ifDivBy5;
    }

    public List<Boolean> prefixesDivBy52(int[] A) {
        int num = 0;
        List<Boolean> ifDivBy5 = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            num = (num * 2 + A[i]) % 10;
            ifDivBy5.add(num % 5 == 0);
        }
        return  ifDivBy5;
    }

    public static void main(String[] args) {
        int A[] = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        //int[] A = {1,1,1,0,1};
        PrefixesDivBy5 res = new PrefixesDivBy5();
        System.out.println(res.prefixesDivBy5(A));
    }
}
