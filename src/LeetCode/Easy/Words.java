package LeetCode.Easy;

import java.util.*;

public class Words {
//    Given an array of strings words, return the words that can be typed using letters of the alphabet on only one
//    row of American keyboard like the image below.
//
//    In the American keyboard:
//
//    the first row consists of the characters "qwertyuiop",
//    the second row consists of the characters "asdfghjkl", and
//    the third row consists of the characters "zxcvbnm".
//
//
//
//    Example 1:
//
//    Input: words = ["Hello","Alaska","Dad","Peace"]
//    Output: ["Alaska","Dad"]
//    Example 2:
//
//    Input: words = ["omk"]
//    Output: []
//    Example 3:
//
//    Input: words = ["adsdf","sfd"]
//    Output: ["adsdf","sfd"]
//
//
//    Constraints:
//
//            1 <= words.length <= 20
//            1 <= words[i].length <= 100
//    words[i] consists of English letters (both lowercase and uppercase).

    public Set<Character> addToSet(String word) {
        char[] lowerCaseWord = word.toLowerCase().toCharArray();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < lowerCaseWord.length; i++) {
            set.add(lowerCaseWord[i]);
        }
        return set;
    }

    public boolean containsAllChars(String word) {
        String rowStr1 = "qwertyuiop";
        String rowStr2 = "asdfghjkl";
        String rowStr3 = "zxcvbnm";

        if (addToSet(rowStr1).containsAll(addToSet(word))) {
            return true;
        }
        else if (addToSet(rowStr2).containsAll(addToSet(word))) {
            return true;
        }
        else if (addToSet(rowStr3).containsAll(addToSet(word))) {
            return true;
        }
        return false;
    }

    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();

        for (String word: words) {
            if (containsAllChars(word)) {
                res.add(word);
            }
        }
        String[] arr = new String[res.size()];

        for (int i =0; i < res.size(); i++)
            arr[i] = res.get(i);
        return arr;
    }

    public static void main(String[] args) {
        String[] word1 = {"Hello","Alaska","Dad","Peace"};
        String[] word2 = {"omk"};
        Words res = new Words();
        System.out.println(Arrays.toString(res.findWords(word1)));
        System.out.println(Arrays.toString(res.findWords(word2)));
    }

}
