package LeetCode.Easy;

import java.util.Arrays;

public class HummingDistance {
//    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//
//    Given two integers x and y, calculate the Hamming distance.
//
//            Note:
//            0 ≤ x, y < 231.
//
//    Example:
//
//    Input: x = 1, y = 4
//
//    Output: 2
//
//    Explanation:
//            1   (0 0 0 1)
//            4   (0 1 0 0)
//            ↑   ↑
//
//    The above arrows point to positions where the corresponding bits are different.

    public int hammingDistance(int x, int y) {

        String xA = Integer.toString(x, 2);
        String yA = Integer.toString(y, 2);

        int diff_count = Math.abs(xA.length() - yA.length());
        StringBuilder zeros = new StringBuilder();
        for (int i = 0 ; i < diff_count; i++) {
            zeros.append("0");
        }
        if (xA.length() < yA.length()) {
            xA = zeros + xA;
        } else {
            yA = zeros + yA;
        }

        int count = 0;
        for (int i = 0; i < xA.length(); i++) {
            if (xA.charAt(i) != yA.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        int x1 = 2, y1 = 4;
        HummingDistance res = new HummingDistance();
        //System.out.println(Arrays.toString(res.binaryToDecimalConversion(4)));
        System.out.println(res.hammingDistance(x, y));
        System.out.println(res.hammingDistance(x1, y1));
    }
}
