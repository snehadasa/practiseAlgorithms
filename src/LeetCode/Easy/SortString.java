package LeetCode.Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortString {
//    Given a string s. You should re-order the string using the following algorithm:
//
//    Pick the smallest character from s and append it to the result.
//    Pick the smallest character from s which is greater than the last appended character to the result and append it.
//    Repeat step 2 until you cannot pick more characters.
//    Pick the largest character from s and append it to the result.
//    Pick the largest character from s which is smaller than the last appended character to the result and append it.
//    Repeat step 5 until you cannot pick more characters.
//    Repeat the steps from 1 to 6 until you pick all characters from s.
//    In each step, If the smallest or the largest character appears more than once you can choose any occurrence
//    and append it to the result.
//
//    Return the result string after sorting s with this algorithm.
//
//
//
//            Example 1:
//
//    Input: s = "aaaabbbbcccc"
//    Output: "abccbaabccba"
//    Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
//    After steps 4, 5 and 6 of the first iteration, result = "abccba"
//    First iteration is done. Now s = "aabbcc" and we go back to step 1
//    After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
//    After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
//    Example 2:
//
//    Input: s = "rat"
//    Output: "art"
//    Explanation: The word "rat" becomes "art" after re-ordering it with the mentioned algorithm.
//    Example 3:
//
//    Input: s = "leetcode"
//    Output: "cdelotee"
//    Example 4:
//
//    Input: s = "ggggggg"
//    Output: "ggggggg"
//    Example 5:
//
//    Input: s = "spo"
//    Output: "ops"
//
//
//    Constraints:
//
//            1 <= s.length <= 500
//    s contains only lower-case English letters.

    public String removeSorted1(StringBuilder s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int smallestIndex = 0;
        char smallestChar = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (smallestChar > s.charAt(i)) {
                smallestChar = s.charAt(i);
                smallestIndex = i;
            }
        }
        result.append(smallestChar);
        s.deleteCharAt(smallestIndex);

        while (true) {
            Integer smallIndex = null;
            Character smallChar = null;
            char lastSmallChar = result.charAt(result.length() - 1);
            for (int i = 0; i < s.length(); i++) {
                if ((smallChar == null && s.charAt(i) > lastSmallChar)
                        || (smallChar != null && s.charAt(i) > lastSmallChar && s.charAt(i) < smallChar)) {
                    smallIndex = i;
                    smallChar = s.charAt(i);
                }
            }
            if (smallChar == null) {
                break;
            } else {
                result.append(smallChar);
                s.deleteCharAt(smallIndex);
            }
        }
        return result.toString();
    }

    public void removeChar(StringBuilder s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                s.deleteCharAt(i);
                return;
            }
        }
    }

    public String removeSorted(StringBuilder s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        char[] sortedChars = s.toString().toCharArray();
        Arrays.sort(sortedChars);

        result.append(sortedChars[0]);
        removeChar(s, sortedChars[0]);

        for (int i = 1; i < sortedChars.length; i++) {
            if (sortedChars[i] != result.charAt(result.length() - 1)) {
                result.append(sortedChars[i]);
                removeChar(s, sortedChars[i]);
            }
        }

        return result.toString();
    }

    public String removeReverseSorted(StringBuilder s) {
        if (s.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char[] reverseSortedChars = s.toString().toCharArray();
        Arrays.sort(reverseSortedChars);
        char[] reverseSort = new char[reverseSortedChars.length];
        for (int i = reverseSortedChars.length - 1; i >= 0; i--) {
            reverseSort[reverseSortedChars.length - 1 - i] = reverseSortedChars[i];
        }

        result.append(reverseSort[0]);
        removeChar(s, reverseSort[0]);

        for (int i = 1; i < reverseSort.length; i++) {
            if (reverseSort[i] != result.charAt(result.length() - 1)) {
                result.append(reverseSort[i]);
                removeChar(s, reverseSort[i]);
            }
        }
        return result.toString();
    }

    public String sortString(String s) {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(s);

        while (stringBuilder.length() >  0) {
            result += removeSorted(stringBuilder);
            result += removeReverseSorted(stringBuilder);
        }
        return result;
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("\"aaaabbbbcccc\"");
        SortString res = new SortString();
        System.out.println(res.sortString("aaaabbbbcccc"));
        //System.out.println("hold");
    }

}


