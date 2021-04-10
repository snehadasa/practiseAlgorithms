package LeetCode.Easy;

import java.util.*;

public class MostCommonWord {
//    Given a string paragraph and a string array of the banned words banned, return the most frequent word that is
//    not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
//
//    The words in paragraph are case-insensitive and the answer should be returned in lowercase.
//
//
//
//            Example 1:
//
//    Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
//    Output: "ball"
//    Explanation:
//            "hit" occurs 3 times, but it is a banned word.
//            "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
//    Note that words in the paragraph are not case sensitive,
//    that punctuation is ignored (even if adjacent to words, such as "ball,"),
//    and that "hit" isn't the answer even though it occurs more because it is banned.
//    Example 2:
//
//    Input: paragraph = "a.", banned = []
//    Output: "a"
//
//
//    Constraints:
//
//            1 <= paragraph.length <= 1000
//    paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
//            0 <= banned.length <= 100
//            1 <= banned[i].length <= 10
//    banned[i] consists of only lowercase English letters.

    public List removeBannedElements(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();

        String[] split = paragraph.split("\\W+");
        List<String> list = new ArrayList<>();

        String[] spaceSplit = Arrays.asList(split).stream().map(String::toLowerCase).toArray(String[]::new);


        for (String word: banned) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < spaceSplit.length; i++) {
            if (!map.containsKey(spaceSplit[i])) {
                list.add(spaceSplit[i]);
            }
        }
        return list;
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = removeBannedElements(paragraph, banned);

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
        }

        int maxValueInMap=(Collections.max(map.values()));// This will return max value in the Hashmap
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue()==maxValueInMap) {
                res = entry.getKey();
            }
        }
        return res;
    }

    public String mostCommonWord1(String paragraph, String[] banned) {

        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet();
        for (String word : banned)
            bannedWords.add(word);

        Map<String, Integer> wordCount = new HashMap();
        // 3). count the appearance of each word, excluding the banned words
        for (String word : words) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 4). return the word with the highest frequency
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        MostCommonWord res = new MostCommonWord();
        System.out.println(res.mostCommonWord(paragraph, banned));
        System.out.println(res.removeBannedElements(paragraph, banned));
    }
}
