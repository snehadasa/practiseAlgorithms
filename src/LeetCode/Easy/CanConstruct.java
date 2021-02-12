package LeetCode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CanConstruct {
//    Given an arbitrary ransom note string and another string containing letters from all the magazines, write a
//    function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will
//        return false.
//
//    Each letter in the magazine string can only be used once in your ransom note.
//
//
//
//            Example 1:
//
//    Input: ransomNote = "a", magazine = "b"
//    Output: false
//    Example 2:
//
//    Input: ransomNote = "aa", magazine = "ab"
//    Output: false
//    Example 3:
//
//    Input: ransomNote = "aa", magazine = "aab"
//    Output: true
//
//
//    Constraints:
//
//    You may assume that both strings contain only lowercase letters.

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] countMag = new int[256];
        int[] countRan = new int[256];
        for (int i = 0; i < magazine.length(); i++) {
            countMag[magazine.charAt(i)]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            countRan[ransomNote.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (countRan[i] > countMag[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        Map<Character, Integer> ransomMap = new HashMap<>();

        for (int  i = 0; i < magazine.length(); i++) {
            if (magazineMap.containsKey(magazine.charAt(i))) {
                int value = magazineMap.get(magazine.charAt(i));
                magazineMap.put(magazine.charAt(i), 1+value);
            } else
                magazineMap.put(magazine.charAt(i), 1);
        }
        for (int  i = 0; i < ransomNote.length(); i++) {
            if (ransomMap.containsKey(ransomNote.charAt(i))) {
                int value = ransomMap.get(ransomNote.charAt(i));
                ransomMap.put(ransomNote.charAt(i), 1+value);
            } else
                ransomMap.put(ransomNote.charAt(i), 1);
        }

        for (Character c : ransomMap.keySet()) {
            if (ransomMap.get(c) > magazineMap.getOrDefault(c, 0)) {
                return false;
            }

        }
        return true;
    }

        public static void main(String[] args) {
        String ransom = "ac", magazine = "aab";
        CanConstruct res = new CanConstruct();
        System.out.println(res.canConstruct1(ransom, magazine));
    }
}
