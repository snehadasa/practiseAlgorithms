package LeetCode.Easy;

public class FindComplement {
//    Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.
//
//
//
//    Example 1:
//
//    Input: num = 5
//    Output: 2
//    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
//    Example 2:
//
//    Input: num = 1
//    Output: 0
//    Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
//
//
//    Constraints:
//
//    The given integer num is guaranteed to fit within the range of a 32-bit signed integer.
//            num >= 1
//    You could assume no leading zero bit in the integer’s binary representation.
//    This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/

    public int binaryToDecimal(String n) {
        int base = 1;
        int decValue = 0;

        for (int i = n.length() - 1; i >= 0; i--) {
            if (n.charAt(i) == '1') {
                decValue += base;
            }
            base *= 2;
        }

        return decValue;
    }

    public int findComplement(int num) {
        String binaryNumber = Integer.toString(num, 2);
        StringBuilder res = new StringBuilder();
        int result = 0;

        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) == '0') {
                res.append(1);
            }
            else if (binaryNumber.charAt(i) == '1') {
                    res.append(0);
                }
        }
        result = binaryToDecimal(res.toString());
        return result;
    }

    public static void main(String[] args) {
        int num = 5;
        FindComplement res = new FindComplement();
        System.out.println(res.findComplement(num));
    }

}
