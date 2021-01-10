package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class CountCharacters {
//    You are given an array of strings words and a string chars.
//
//    A string is good if it can be formed by characters from chars (each character can only be used once).
//
//    Return the sum of lengths of all good strings in words.
//
//
//
//            Example 1:
//
//    Input: words = ["cat","bt","hat","tree"], chars = "atach"
//    Output: 6
//    Explanation:
//    The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
//    Example 2:
//
//    Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//    Output: 10
//    Explanation:
//    The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
//
//
//    Note:
//
//            1 <= words.length <= 1000
//            1 <= words[i].length, chars.length <= 100
//    All strings contain lowercase English letters only.


    public int countCharacters1(String[] words, String chars) {
        int total = 0;
        ArrayList<String> selected = new ArrayList<>();

        for (String word : words) {
            char[] wordToChar = word.toCharArray();
            char[] charsToCharArr = chars.toCharArray();
            StringBuilder newS = new StringBuilder();
            for (int i = 0; i < wordToChar.length; i++) {
                for (int j = 0; j < charsToCharArr.length; j++) {
                    if (wordToChar[i] == charsToCharArr[j]) {
                        newS.append(wordToChar[i]);
                        charsToCharArr[j] = '\0';
                        break;
                    }
                }
            }
            if (newS.toString().equals(word)) {
                selected.add(word);
                total += word.length();
            }
        }
        return total;
    }

        public static void main(String[] args) {
        String words[] = {"cat","bt","hat","tree"};
        String chars = "atach";
        CountCharacters res = new CountCharacters();
        System.out.println(res.countCharacters1(words, chars));
    }
}
