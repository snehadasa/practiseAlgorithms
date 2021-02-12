package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsAlienSorted {
//    In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
//    The order of the alphabet is some permutation of lowercase letters.
//
//    Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only
//        if the given words are sorted lexicographicaly in this alien language.
//
//
//
//    Example 1:
//
//    Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//    Output: true
//    Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
//            Example 2:
//
//    Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//    Output: false
//    Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
//            Example 3:
//
//    Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//    Output: false
//    Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
//
//
//    Constraints:
//
//            1 <= words.length <= 100
//            1 <= words[i].length <= 20
//    order.length == 26
//    All characters in words[i] and order are English lowercase letters.

    //public boolean isLexicographicallySorted(String word1, String word2, HashMap<Character, Integer> order) {
//        if (word1 == "") {
//             order.add(word2);
//        }
//        if (word2 == "") {
//            order.add(word1);
//        }
//        if (word1.length() < word2.length()) {
//            order.add(word1);
//            order.add(word2);
//        }
//        if (word2.length() < word2.length()) {
//            order.add(word2);
//            order.add(word1);
//        }
//        if (word1.length() == word2.length()) {
//            for (int i = 0; i < word1.length() && i < word2.length(); i++) {
//                if (word1.charAt(i) < word2.charAt(i)) {
//                    order.add(word1);
//                    order.add(word2);
//                }
//                else if (word1.charAt(i) > word2.charAt(i)) {
//                    order.add(word2);
//                    order.add(word1);
//                }
//                else if (word1.charAt(i) == word2.charAt(i)) {
//                    continue;
//                }
//            }
//        }
//        return order;
//}

    public boolean isLexicographicallySorted(String word1, String word2, Map<Character, Integer> order) {
        for (int i = 0; i < word1.length() && i < word2.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return order.get(word1.charAt(i)) <= order.get(word2.charAt(i));
            }
        }
        return word1.length() <= word2.length();
    }
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderPlaceValue = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderPlaceValue.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length; i++) {
            String word1 = words[0];
            String word2 = words[1];

            if (!isLexicographicallySorted(word1, word2, orderPlaceValue)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        IsAlienSorted res = new IsAlienSorted();
        System.out.println(res.isAlienSorted(words, order));
    }
}
