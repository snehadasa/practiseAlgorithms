package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxScore {
//    Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty
//    substrings (i.e. left substring and right substring).
//
//    The score after splitting a string is the number of zeros in the left substring plus the number of ones
//    in the right substring.
//
//
//
//    Example 1:
//
//    Input: s = "011101"
//    Output: 5
//    Explanation:
//    All possible ways of splitting s into two non-empty substrings are:
//    left = "0" and right = "11101", score = 1 + 4 = 5
//    left = "01" and right = "1101", score = 1 + 3 = 4
//    left = "011" and right = "101", score = 1 + 2 = 3
//    left = "0111" and right = "01", score = 1 + 1 = 2
//    left = "01110" and right = "1", score = 2 + 1 = 3
//    Example 2:
//
//    Input: s = "00111"
//    Output: 5
//    Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
//    Example 3:
//
//    Input: s = "1111"
//    Output: 3
//
//
//    Constraints:
//
//            2 <= s.length <= 500
//    The string s consists of characters '0' and '1' only.

    //method1
    public int maxScore(String s) {
        int count = 0, maxCount = 0;
        int[] countZeros = new int[s.length()];
        int[] countOnes = new int[s.length()];

        //count for first elements i.e., for 0th element
        if (s.charAt(0) == '1') {
            countOnes[0] = 1;
        } else
            countZeros[0] = 1;


        //count from 1st element to the last
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOnes[i] = countOnes[i-1] + 1;
                countZeros[i] = countZeros[i-1];
            } else {
                countZeros[i] = countZeros[i - 1] + 1;
                countOnes[i] = countOnes[i - 1];
            }
        }

        for (int i = 1; i <= s.length()-1; i++) {
            count = countZeros[i-1] + countOnes[s.length()-1] - countOnes[i-1];
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    //method2
    public int maxScore1(String s) {
        int maxScore = 0;
        int score = 0;

        for (int i = 1; i <= s.length()-1; i++) {
            score = countZeros(s.substring(0,i)) + countOnes(s.substring(i, s.length()));
            if (score > maxScore) {
                maxScore = score;
            }
        }

        return maxScore;
    }


    private int countOnes(String substring) {
        int count = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    private int countZeros(String substring) {
        int count = 0;
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "1111";
        String s2 = "00111";
        String s3 = "00";
        MaxScore res = new MaxScore();
        System.out.println(res.maxScore(s1));
        System.out.println(res.maxScore(s2));
        System.out.println(res.maxScore(s3));
    }
}
