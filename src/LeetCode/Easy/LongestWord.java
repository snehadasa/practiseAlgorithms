package LeetCode.Easy;

import java.util.*;

public class LongestWord {
//    Given a list of strings words representing an English Dictionary, find the longest word in words that can be built
//    one character at a time by other words in words. If there is more than one possible answer, return the longest word
//    with the smallest lexicographical order.
//
//    If there is no answer, return the empty string.
//            Example 1:
//    Input:
//    words = ["w","wo","wor","worl", "world"]
//    Output: "world"
//    Explanation:
//    The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
//    Example 2:
//    Input:
//    words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//    Output: "apple"
//    Explanation:
//    Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically
//    smaller than "apply".
//    Note:
//
//    All the strings in the input will only contain lowercase letters.
//    The length of words will be in the range [1, 1000].
//    The length of words[i] will be in the range [1, 30].

    public boolean indiviualWord(String[] words, String singleWord) {
        for (int i = 0; i < singleWord.length(); i++) {
            if (singleWord.contains(words[i])) {
                 return true;
            }
        }
        return false;
    }
//    public List<String> allPrefixesOfWord(String word) {
//        StringBuilder prefixes = new StringBuilder();
//        List<String> res = new ArrayList<>();
//        for (int i = 0; i < word.length(); i++) {
//            prefixes
//        }
//    }
    public String longestWord(String[] words) {
       Set<String> wordSet = new HashSet<>();
       String res = "";

       for (String word: words) {
           wordSet.add(word);
       }

       for (String word: words) {
           if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
               boolean prefixIsPresent = true;



               for (int i = 1; i < word.length(); i++) {
                   if (!wordSet.contains(word.substring(0,i))) {
                       prefixIsPresent = false;
                       break;
                   }
               }
               if (prefixIsPresent) {
                   res = word;
               }
           }
       }
       return res;
    }

    public String longestWord1(String[] words) {
        Arrays.sort(words);
        String result = "";
        HashSet<String> builtWords = new HashSet();
        for(String w : words) {
            if(w.length() == 1 || builtWords.contains(w.substring(0, w.length()-1))) {
                if(w.length() > result.length()) result = w;
                builtWords.add(w);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"w","wo","wor","worl", "world"};
        LongestWord res = new LongestWord();
        System.out.println(res.longestWord(words));
    }
}
