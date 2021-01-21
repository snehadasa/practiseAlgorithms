package LeetCode.Easy;

public class MaxLengthBetweenEqualCharacters {
//    Given a string s, return the length of the longest substring between two equal characters, excluding the two
//    characters. If there is no such substring return -1.
//
//    A substring is a contiguous sequence of characters within a string.
//
//
//
//            Example 1:
//
//    Input: s = "aa"
//    Output: 0
//    Explanation: The optimal substring here is an empty substring between the two 'a's.
//            Example 2:
//
//    Input: s = "abca"
//    Output: 2
//    Explanation: The optimal substring here is "bc".
//    Example 3:
//
//    Input: s = "cbzxy"
//    Output: -1
//    Explanation: There are no characters that appear twice in s.
//            Example 4:
//
//    Input: s = "cabbac"
//    Output: 4
//    Explanation: The optimal substring here is "abba". Other non-optimal substrings include "bb" and "".
//
//
//    Constraints:
//
//            1 <= s.length <= 300
//    s contains only lowercase English letters.

    public int maxLengthBetweenEqualCharacters(String s) {
        int lenOfLongestSubstring = -1;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    lenOfLongestSubstring = Math.max(i - j - 1, lenOfLongestSubstring);
                    break;
                }
            }
        }
        return lenOfLongestSubstring;
    }

    public static void main(String[] args) {
        String s1 = "cabbac";
        String s2 = "abca";
        String s3 = "aa";
        String s4 = "cbzxy";
        MaxLengthBetweenEqualCharacters res = new MaxLengthBetweenEqualCharacters();
        System.out.println(res.maxLengthBetweenEqualCharacters(s1));
        System.out.println(res.maxLengthBetweenEqualCharacters(s2));
        System.out.println(res.maxLengthBetweenEqualCharacters(s3));
        System.out.println(res.maxLengthBetweenEqualCharacters(s4));
    }
}
