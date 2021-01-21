package LeetCode.Easy;

import java.util.Arrays;

public class ThousandSeparator {
//    Given an integer n, add a dot (".") as the thousands separator and return it in string format.
//
//
//
//    Example 1:
//
//    Input: n = 987
//    Output: "987"
//    Example 2:
//
//    Input: n = 1234
//    Output: "1.234"
//    Example 3:
//
//    Input: n = 123456789
//    Output: "123.456.789"
//    Example 4:
//
//    Input: n = 0
//    Output: "0"
//
//
//    Constraints:
//
//            0 <= n < 2^31

    public void swap(char[] character, int i, int j) {
        char temp = character[i];
        character[i] = character[j];
        character[j] = temp;
    }



    public String thousandSeparator1(int n) {
        StringBuilder res = new StringBuilder();
        //StringBuilder reverseNum = new StringBuilder();
        String number = String.valueOf(n);
        int len = number.length();
        char[] reverseNum = number.toCharArray();

        for (int i = len-1, j = 0; i >= 0; i--) {
            reverseNum[j++] = number.charAt(i);
        }
        for (int i = 0; i < reverseNum.length-2; i+=3) {
            res.append(reverseNum[i]);
            res.append(reverseNum[i+1]);
            res.append(reverseNum[i+2]);
            res.append(".");
            reverseNum[i] = 0;
            reverseNum[i+1] = 0;
            reverseNum[i+2] = 0;
        }

        if (reverseNum.length < 3) {
            for (int i = 0; i < reverseNum.length-1; i++) {
                res.append(reverseNum[i]);
                reverseNum[i] = 0;
            }
        }

        return String.valueOf(res.reverse());
        //return reverseNum;
    }

    public String thousandSeparator(int n) {
       StringBuilder res = new StringBuilder();
       int count = 0;

       while (n > 0) {
           int rem = n%10;
           n /= 10;
           count++;
           res.append(rem);

           if (n > 0 && count == 3) {
               res.append(".");
               count = 0;
           }
       }
        if (res.length() == 0) {
            return "0";
        }
       return res.reverse().toString();
    }

        public static void main(String[] args) {
        int n = 12345678;
        ThousandSeparator res = new ThousandSeparator();
        System.out.println(res.thousandSeparator(n));
        //System.out.println(Arrays.toString(res.thousandSeparator(n)));
    }
}
