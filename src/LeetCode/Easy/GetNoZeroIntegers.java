package LeetCode.Easy;

import java.util.Arrays;

public class GetNoZeroIntegers {
//    Given an integer n. No-Zero integer is a positive integer which doesn't contain any 0 in its decimal representation.
//
//    Return a list of two integers [A, B] where:
//
//    A and B are No-Zero integers.
//    A + B = n
//    It's guarateed that there is at least one valid solution. If there are many valid solutions you can return any of them.
//
//
//
//    Example 1:
//
//    Input: n = 2
//    Output: [1,1]
//    Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in their decimal representation.
//    Example 2:
//
//    Input: n = 11
//    Output: [2,9]
//    Example 3:
//
//    Input: n = 10000
//    Output: [1,9999]
//    Example 4:
//
//    Input: n = 69
//    Output: [1,68]
//    Example 5:
//
//    Input: n = 1010
//    Output: [11,999]
//
//
//    Constraints:
//
//            2 <= n <= 10^4

    public boolean ifContains0(int n) {
        String nString = String.valueOf(n);

        for (int i = 0; i < nString.length(); i++) {
            if (nString.contains("0")) {
                return true;
            }
        }
        return false;
    }

    public int[] getNoZeroIntegers(int n) {
        int[] sumIntegers = new int[2];
        int sum = n;
        int number1 = 1;
        int number2 = sum - number1;

        while (ifContains0(number1) || ifContains0(number2)) {
            number1++;
            number2--;

        }
        sumIntegers[0] = number1;
        sumIntegers[1] = number2;

        return sumIntegers;
    }

    public int[] getNoZeroIntegers1(int n) {
        int[] sumIntegers = new int[2];
        int sum = n;
        int number1 = 1;
        int number2 = sum - number1;


        int base  = 1;
        int toSubtract = 0;
        int temp = number2;
        int carry = 1;

        while (temp/10 != 0) {
            if (temp % 10 ==  carry) {
                toSubtract += base;
            }
            base *= 10;
            temp = temp/10;
        }
        number1 += toSubtract;
        number2 -= toSubtract;


        sumIntegers[0] = number1;
        sumIntegers[1] = number2;

        return sumIntegers;
    }

    public static void main(String[] args) {
        int n = 1010;
        GetNoZeroIntegers res = new GetNoZeroIntegers();
        System.out.println(Arrays.toString(res.getNoZeroIntegers1(n)));
        //System.out.println(res.ifContains0(n));
    }
}
