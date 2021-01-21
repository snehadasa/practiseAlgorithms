package LeetCode.Easy;

import java.util.Arrays;

public class IsAnagram {
//    Given two strings s and t , write a function to determine if t is an anagram of s.
//
//    Example 1:
//
//    Input: s = "anagram", t = "nagaram"
//    Output: true
//    Example 2:
//
//    Input: s = "rat", t = "car"
//    Output: false
//    Note:
//    You may assume the string contains only lowercase alphabets.
//
//    Follow up:
//    What if the inputs contain unicode characters? How would you adapt your solution to such case?

    public boolean isAnagram(String s, String t) {
        char[] sToArr = s.toCharArray();
        char[] tToArr = t.toCharArray();

        Arrays.sort(sToArr);
        Arrays.sort(tToArr);

        String sNew = String.valueOf(sToArr);
        String tNew = String.valueOf(tToArr);

        if (sNew.equals(tNew)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsAnagram res = new IsAnagram();
        String s = "anagram";
        String t = "nagara";
        System.out.println(res.isAnagram(s, t));
    }
}
