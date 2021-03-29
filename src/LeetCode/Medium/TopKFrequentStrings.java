package LeetCode.Medium;

import java.util.*;

public class TopKFrequentStrings {
//    Given a non-empty list of words, return the k most frequent elements.
//
//    Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the
//    word with the lower alphabetical order comes first.
//
//    Example 1:
//    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//    Output: ["i", "love"]
//    Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.
//    Example 2:
//    Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
//    Output: ["the", "is", "sunny", "day"]
//    Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//    with the number of occurrence being 4, 3, 2 and 1 respectively.
//            Note:
//    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//    Input words contain only lowercase letters.
//    Follow up:
//    Try to solve it in O(n log k) time and O(n) extra space.

    class Pair {
        private String word;
        private Integer count;

        public String getWord() {
            return word;
        }

        public Integer getCount() {
            return count;
        }

        public Pair(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
    }
    public List topKFrequent(String[] words, int k) {
        List<Pair> pairOfCount = new ArrayList<>();
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pairOfCount.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(pairOfCount, (Pair a, Pair b) -> (a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count));

        for (int i = 0; i < k; i++) {
            res.add(pairOfCount.get(i).word);
        }

        //Collections.sort(res, );
       // res.sort(Comparator.comparing(String::toString));
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        TopKFrequentStrings res = new TopKFrequentStrings();
        System.out.println(res.topKFrequent(words, k));
    }
}
