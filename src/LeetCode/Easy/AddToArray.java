package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class AddToArray {
//    For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example,
//    if X = 1231, then the array form is [1,2,3,1].
//
//    Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
//
//
//
//            Example 1:
//
//    Input: A = [1,2,0,0], K = 34
//    Output: [1,2,3,4]
//    Explanation: 1200 + 34 = 1234
//    Example 2:
//
//    Input: A = [2,7,4], K = 181
//    Output: [4,5,5]
//    Explanation: 274 + 181 = 455
//    Example 3:
//
//    Input: A = [2,1,5], K = 806
//    Output: [1,0,2,1]
//    Explanation: 215 + 806 = 1021
//    Example 4:
//
//    Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
//    Output: [1,0,0,0,0,0,0,0,0,0,0]
//    Explanation: 9999999999 + 1 = 10000000000

    public String arrayToString(int[] A) {
        StringBuilder number = new StringBuilder();

        for (int a: A) {
            number.append(a);
        }

        return number.toString();
    }

    public int convertStringToInt(String number) {
        int num = 0, factor = 1;

        for (int i = number.length() - 1; i >= 0; i--) {
            num += (number.charAt(i) - '0') * factor;
            factor *= 10;
        }
        return num;
    }

    public int reverseInteger(int num) {
        int rev = 0, remainder = 0;
        while (num != 0) {
            int digit = num%10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        return rev;
    }

    public List<Integer> addToArrayForm1(int[] A, int K) {
        List<Integer> list = new ArrayList<>();

        String nStr = arrayToString(A);
        long num = convertStringToInt(nStr);

        int sum = (int)num + K;
        String sumStr = String.valueOf(sum);

        for (int i = 0; i < sumStr.length(); i++) {
            list.add(sumStr.charAt(i) - '0');
        }
        return list;
    }

    //method2
    public String revString(String a) {
        StringBuilder rev = new StringBuilder();

        for (int i = a.length()-1; i >= 0; i--) {
            rev.append(a.charAt(i));
        }
        return rev.toString();
    }
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int sum = 0, carry = 0;

        String k = String.valueOf(K);

        StringBuilder res = new StringBuilder();

        String nStr = arrayToString(A);
        int len1 = nStr.length()-1;
        int len2 = k.length()-1;

        while (len1 >= 0 || len2 >= 0) {
            int x = 0, y = 0;

            if (len1 >= 0) {
                x = nStr.charAt(len1) - '0';
                len1--;
            }

            if (len2 >= 0) {
                y = k.charAt(len2) - '0';
                len2--;
            }

            sum = (x+y+carry)%10;
            carry = (x+y+carry) / 10;

            res.append(sum);
        }

        if (carry != 0) {
            res.append(carry);
        }
        String sumStr = res.toString();

        for (int i = sumStr.length()-1; i >= 0; i--) {
            list.add(sumStr.charAt(i) - '0');
        }

        return list;
    }

    //method3

        public static void main(String[] args) {
        int[] A1 = {9,9,9,9,9,9,9,9,9,9}, A2 = {1,2,0,0};
        int k = 1, k1 = 34;
        AddToArray res = new AddToArray();
        //System.out.println(res.arrayToString(A));
        //System.out.println(res.convertStringToInt("56"));
        System.out.println(res.addToArrayForm(A1, k));
        System.out.println(res.addToArrayForm(A2, k1));
            //System.out.println(res.reverseInteger(57));
    }
}
