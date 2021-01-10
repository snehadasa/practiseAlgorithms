package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CommonChars {
//    Given an array A of strings made only from lowercase letters, return a list of all characters that show up in
//    all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings
//    but not 4 times, you need to include that character three times in the final answer.
//
//    You may return the answer in any order.
//
//
//
//            Example 1:
//
//    Input: ["bella","label","roller"]
//    Output: ["e","l","l"]
//    Example 2:
//
//    Input: ["cool","lock","cook"]
//    Output: ["c","o"]
//
//
//    Note:
//
//            1 <= A.length <= 100
//            1 <= A[i].length <= 100
//    A[i][j] is a lowercase letter

    boolean containsChar(StringBuilder s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    void deleteCharAtI(StringBuilder s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                s.deleteCharAt(i);
                return;
            }
        }
    }
    public List<String>  commonChars(String[] A) {
        StringBuilder []aToStr = new StringBuilder[A.length];
        List<String> result = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            aToStr[i] = new StringBuilder(A[i]);
        }

        String myString = A[0];
        for (int i = 0; i < myString.toCharArray().length; i++) { //for (char c : myString.toCharArray()) {
                boolean found = true;
            for (StringBuilder currentStr: aToStr) {
                if (!containsChar(currentStr, myString.charAt(i))) {
                    found = false;
                    break;
                }
                deleteCharAtI(currentStr, myString.charAt(i));
            }
            if (found) {
                result.add(Character.toString(myString.charAt(i)));
            }
        }
        return result;
    }

        public static void main(String[] args) {
        String []A = {"coolc","locck","cook"};
        CommonChars res = new CommonChars();
        System.out.println(res.commonChars(A));
    }
}
