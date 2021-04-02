package LeetCode.Easy;

public class ConvertToBase7 {
//    Given an integer, return its base 7 string representation.
//
//    Example 1:
//    Input: 100
//    Output: "202"
//    Example 2:
//    Input: -7
//    Output: "-10"
//    Note: The input will be in range of [-1e7, 1e7].

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        int n = num;
        boolean isNeg = n < 0;
        StringBuilder res = new StringBuilder();
        n = Math.abs(n);

        while (n != 0) {
            res.append(n%7);
            n /= 7;
        }
        if (isNeg) {
            res.append('-');
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        int num = 100;
        ConvertToBase7 res = new ConvertToBase7();
        System.out.println(res.convertToBase7(num));
    }
}
