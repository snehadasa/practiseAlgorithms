package LeetCode.Easy;

import java.util.*;

public class CountConsistentStrings {
    //    You are given a string allowed consisting of distinct characters and an array of strings words.
//    A string is consistent if all characters in the string appear in the string allowed.
//
//    Return the number of consistent strings in the array words.
//
//
//
//    Example 1:
//
//    Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
//    Output: 2
//    Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
//    Example 2:
//
//    Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
//    Output: 7
//    Explanation: All strings are consistent.
//    Example 3:
//
//    Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
//    Output: 4
//    Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
//
//
//    Constraints:
//
//            1 <= words.length <= 104
//            1 <= allowed.length <= 26
//            1 <= words[i].length <= 10
//    The characters in allowed are distinct.
//    words[i] and allowed contain only lowercase English letters.
    public boolean isConsistentString(String allowed, String word) {
        char[] allowedC = allowed.toCharArray();
        char[] wordC = word.toCharArray();
        for (int i = 0; i < wordC.length; i++) {
            boolean found = false;
            for (int j = 0; j < allowedC.length; j++) {
                if (allowedC[j] == wordC[i]) {
                    found = true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }


    public boolean isConsistentString1(String allowed, String word) {
        char[] allowedC = allowed.toCharArray();
        char[] wordC = word.toCharArray();
        Map<Character, Boolean> isFound = new HashMap<>();
        for (char c : allowedC) {
            isFound.put(c, true);
        }

        for (int i = 0; i < wordC.length; i++) {
            if (!isFound.containsKey(wordC[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isConsistentString2(String allowed, String word) {
        char[] allowedC = allowed.toCharArray();
        char[] wordC = word.toCharArray();
        Set<Character> isFound = new HashSet<>();
        for (char c : allowedC) {
            isFound.add(c);
        }

        for (int i = 0; i < wordC.length; i++) {
            if (!isFound.contains(wordC[i])) {
                return false;
            }
        }
        return true;
    }


    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isConsistentString2(allowed, word)) {
                count++;
            }
        }
        return count;
    }


    public int countConsistentStrings1(String allowed, String[] words) {
        return (int) Arrays.stream(words).map(word -> isConsistentString2(allowed, word)).filter(isConsistent -> isConsistent).count();
    }

    public static void main(String[] args) {
        String allowed = "ab", allowed1 = "abc";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"}, words1 = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        //String word = ""

        CountConsistentStrings res = new CountConsistentStrings();
        System.out.println(res.countConsistentStrings1(allowed, words));
        System.out.println(res.countConsistentStrings1(allowed1, words1));
    }
}
