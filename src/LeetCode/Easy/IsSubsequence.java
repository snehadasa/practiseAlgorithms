package LeetCode.Easy;

import java.util.Arrays;

public class IsSubsequence {
//    Given two strings s and t, check if s is a subsequence of t.
//
//    A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
//    of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a
//    subsequence of "abcde" while "aec" is not).
//
//
//
//    Example 1:
//
//    Input: s = "abc", t = "ahbgdc"
//    Output: true
//    Example 2:
//
//    Input: s = "axc", t = "ahbgdc"
//    Output: false
//
//
//    Constraints:
//
//            0 <= s.length <= 100
//            0 <= t.length <= 104
//    s and t consist only of lowercase English letters.
//
//
//    Follow up: If there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to
//    see if t has its subsequence. In this scenario, how would you change your code?

    public boolean ifContains(String s, char c) {
        char[] sArr = s.toCharArray();
        boolean isFound = false;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == c) {
                isFound =  true;
                break;
            }
        }
        return isFound;
    }
    public boolean isSubsequence1(String s, String t) {
        boolean[] isFound = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i < i+1) {
                isFound[i] = ifContains(t, s.charAt(i));
            }
        }

        for (int i = 0; i < isFound.length; i++) {
            if (isFound[i] == false) {
                return false;
            }
        }
        return true;
    }

    public boolean isSubsequence(String s, String t) {
       int i = 0, j = 0, res = 0;

       while (i < s.length()) {
           if (j == t.length()) {
               break;
           }
           if (s.charAt(i) == t.charAt(j)) {
               res++;
               i++;
               j++;
           } else {
               j++;
           }
       }

       if (res == s.length()) {
           return true;
       }
       return false;
    }

        public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        IsSubsequence res = new IsSubsequence();
        System.out.println(res.isSubsequence(s,t));
        //System.out.println(res.ifContains(t, 'a'));
    }
}
