package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RotateString {
//    We are given two strings, A and B.
//
//    A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example,
//    if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some
//    number of shifts on A.
//
//            Example 1:
//    Input: A = 'abcde', B = 'cdeab'
//    Output: true
//
//    Example 2:
//    Input: A = 'abcde', B = 'abced'
//    Output: false
//    Note:
//
//    A and B will have length at most 100.

    public Set rotate(String a) {
        Set<String> litsOfRotatedStrings = new HashSet<>();
        String rotated = "";

        for (int i = 0; i < a.length(); i++) {
            rotated = a.substring(i) + a.substring(0, i);
            litsOfRotatedStrings.add(rotated);
        }
        return litsOfRotatedStrings;
    }

    public boolean rotateString1(String A, String B) {
        Set<String> rotatedStrings = rotate(A);

        if (A.length() < 1 && B.length() >= 1) {
            return false;
        }

        for (String s : rotatedStrings) {
            if (!rotatedStrings.contains(B)) {
                return false;
            }
        }
        return true;
    }

    public boolean rotateStr(String a, String b) {
        String rotated = "";

        if (a.length() < 1 && b.length() < 1) {
            return true;
        }
        for (int i = 0; i < a.length(); i++) {
            rotated = a.substring(i) + a.substring(0, i);
            if (rotated.equals(b)) {
                return true;
            }
        }
        return false;
    }
    public boolean rotateString(String A, String B) {
        return rotateStr(A, B);
    }

        public static void main(String[] args) {
        String a1 = "abcde", b1 = "bcdea";
        String a2 = "", b2 = "a";
        RotateString res = new RotateString();
        System.out.println(res.rotateString(a1, b1));
        System.out.println(res.rotateString(a2, b2));
    }
}
