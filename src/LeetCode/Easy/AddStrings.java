package LeetCode.Easy;

public class AddStrings {
//    Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//
//    Note:
//
//    The length of both num1 and num2 is < 5100.
//    Both num1 and num2 contains only digits 0-9.
//    Both num1 and num2 does not contain any leading zero.
//    You must not use any built-in BigInteger library or convert the inputs to integer directly.

    public String addStrings1(String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);

        int add = n1+n2;
        return String.valueOf(add);
    }

    public String addStrings(String num1, String num2) {
       int len1 = num1.length()-1;
       int len2 = num2.length()-1;
       int sum = 0, carry = 0;

       StringBuilder res = new StringBuilder();

       while (len1 >= 0 || len2 >= 0) {
           int x1 = 0, x2 = 0;

           if (len1 >= 0) {
               x1 = num1.charAt(len1) - '0';  //to get the integer value
               len1--;
           }
           if (len2 >= 0) {
               x2 = num2.charAt(len2) - '0';  //to get the integer value
               len2--;
           }

           sum = (x1+x2+carry) % 10;
           carry = (x1+x2+carry) / 10;

           res.append(sum);
       }
       if (carry != 0) {
           res.append(carry);
       }
       return res.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "5", num2 = "10";
        AddStrings res = new AddStrings();
        System.out.println(res.addStrings(num1, num2));
    }
}
