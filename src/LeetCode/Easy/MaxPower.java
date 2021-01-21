package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class MaxPower {
//    Given a string s, the power of the string is the maximum length of a non-empty substring that
//    contains only one unique character.
//
//    Return the power of the string.
//
//    Example 1:
//
//    Input: s = "leetcode"
//    Output: 2
//    Explanation: The substring "ee" is of length 2 with the character 'e' only.
//            Example 2:
//
//    Input: s = "abbcccddddeeeeedcba"
//    Output: 5
//    Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
//            Example 3:
//
//    Input: s = "triplepillooooow"
//    Output: 5
//    Example 4:
//
//    Input: s = "hooraaaaaaaaaaay"
//    Output: 11
//    Example 5:
//
//    Input: s = "tourist"
//    Output: 1
//
//
//    Constraints:
//
//            1 <= s.length <= 500
//    s contains only lowercase English letters.

    public int maxPower(String s) {
        boolean flag = false;
        int count = 1;
        List<Integer> countArr = new ArrayList<>();

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)){
                count++;
            }
            if (s.charAt(i) != s.charAt(i+1)) {
                countArr.add(count);
                count = 0;
                count++;
            }

        }
        countArr.add(count);

        int max = countArr.get(countArr.size()-1);
        for (int i = 0; i < countArr.size(); i++) {
            max = Math.max(countArr.get(i), max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPower res = new MaxPower();
        String s1 = "leetcode";
        String s2 = "abbcccddddeeeeedcbadd";
        System.out.println(res.maxPower(s1));
        System.out.println(res.maxPower(s2));
    }
}
