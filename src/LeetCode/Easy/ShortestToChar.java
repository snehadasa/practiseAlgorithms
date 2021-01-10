package LeetCode.Easy;

import java.util.Arrays;

public class ShortestToChar {
    //    Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
//
//            Example 1:
//
//    Input: S = "loveleetcode", C = 'e'
//    Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
//
//
//    Note:
//
//    S string length is in [1, 10000].
//    C is a single character, and guaranteed to be in string S.
//    All letters in S and C are lowercase.

    public int[] shortestToChar(String S, char C) {
        int pos = -1;
        int[] distance = new int[S.length()];
        char[] sToChar = S.toCharArray();

        for (int i=0; i< sToChar.length; i++) {
            if (sToChar[i] == C) {
                pos = i;
            }
            if (pos >= 0) {
                distance[i] = Math.abs(pos - i);
            }
        }
        for (int i= sToChar.length - 1; i >= 0; i--) {
            if (sToChar[i] == C) {
                pos = i;
            }
            if (pos > 0) {
                if (distance[i] == 0 || distance[i] > pos - i) {
                    distance[i] = Math.abs(pos - i);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String S = "loveleetcode";
        char c = 'e';
        ShortestToChar res = new ShortestToChar();
        System.out.println(Arrays.toString(res.shortestToChar(S, c)));
    }

}
