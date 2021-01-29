package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class Reformat {
//    Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
//
//    You have to find a permutation of the string where no letter is followed by another letter and no digit is
//    followed by another digit. That is, no two adjacent characters have the same type.
//
//    Return the reformatted string or return an empty string if it is impossible to reformat the string.
//
//
//
//            Example 1:
//
//    Input: s = "a0b1c2"
//    Output: "0a1b2c"
//    Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are
//    also valid permutations.
//    Example 2:
//
//    Input: s = "leetcode"
//    Output: ""
//    Explanation: "leetcode" has only characters so we cannot separate them by digits.
//    Example 3:
//
//    Input: s = "1229857369"
//    Output: ""
//    Explanation: "1229857369" has only digits so we cannot separate them by characters.
//    Example 4:
//
//    Input: s = "covid2019"
//    Output: "c2o0v1i9d"
//    Example 5:
//
//    Input: s = "ab123"
//    Output: "1a2b3"
//
//
//    Constraints:
//
//            1 <= s.length <= 500
//    s consists of only lowercase English letters and/or digits.

    public String reformat(String s) {
        StringBuilder sb = new StringBuilder();

        List<Character> letters = new ArrayList<>();
        List<Character> numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                letters.add(s.charAt(i));
            } else {
                numbers.add(s.charAt(i));
            }
        }

        if (Math.abs(letters.size() - numbers.size()) > 1) {
            return "";
        }

        for (int i = 0; i < letters.size() && i < numbers.size(); i++) {
           if (letters.size() > numbers.size()) {
                sb.append(letters.get(i));
                sb.append(numbers.get(i));
            } else {
                sb.append(numbers.get(i));
                sb.append(letters.get(i));
            }
        }
        if (letters.size() > numbers.size()) {
            sb.append(letters.get(letters.size() - 1));
        }
        if (numbers.size() > letters.size()) {
            sb.append(numbers.get(numbers.size() - 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "covid2019";
        String s2 = "ab123";
        String s3 = "a0b1c2";
        String s4 = "leetcode";
        Reformat res = new Reformat();
        System.out.println(res.reformat(s1));
        System.out.println(res.reformat(s2));
        System.out.println(res.reformat(s3));
        System.out.println(res.reformat(s4));
    }
}
