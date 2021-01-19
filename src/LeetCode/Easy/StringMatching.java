package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringMatching {
//    Given an array of string words. Return all strings in words which is substring of another word in any order.
//
//    String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
//
//
//
//    Example 1:
//
//    Input: words = ["mass","as","hero","superhero"]
//    Output: ["as","hero"]
//    Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
//            ["hero","as"] is also a valid answer.
//            Example 2:
//
//    Input: words = ["leetcode","et","code"]
//    Output: ["et","code"]
//    Explanation: "et", "code" are substring of "leetcode".
//    Example 3:
//
//    Input: words = ["blue","green","bu"]
//    Output: []
//
//
//    Constraints:
//
//            1 <= words.length <= 100
//            1 <= words[i].length <= 30
//    words[i] contains only lowercase English letters.
//            It's guaranteed that words[i] will be unique.

    public boolean isSubstring(String word1, String word2) {
        for (int i = 0; i < word1.length(); i++) {
            if (word1.contains(word2)) {
                return true;
            }
        }

        return false;
    }

    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i] != words[j] && isSubstring(words[i], words[j])) {
                    //list.add(words[j]);
                    res.add(words[j]);
                }
            }
        }

        for (String entry : res) {
            list.add(entry);
        }
        return list;
    }

    public static void main(String[] args) {
        String word1 = "leetcode", word2 = "clde";
        String[] words = {"mass", "as", "hero", "superhero" };
        String[] words1 = {"leetcoder","leetcode","od","hamlet","am"};
        StringMatching res = new StringMatching();
        //System.out.println(res.isSubstring(word1, word2));
        System.out.println(res.stringMatching(words));
        System.out.println(res.stringMatching(words1));
    }
}
