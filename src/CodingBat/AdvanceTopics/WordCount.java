package CodingBat.AdvanceTopics;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

//    The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each
//    different string, with the value the number of times that string appears in the array.
//
//
//            wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
//    wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
//    wordCount(["c", "c", "c", "c"]) → {"c": 4}

    public Map<String, Integer> wordCount1(String[] strings) {
        Map<String, Integer> hm = new HashMap<>();

        for (String str: strings) {
            if (hm.containsKey(str)) {
                Integer count = hm.get(str);
                hm.put(str, count + 1);
            } else {
                hm.put(str, 1);
            }
        }
        return hm;
    }

    public int wordCount(String[] str) {
        int count = 0;
        String compareTo = "";
        for (int i = 0; i < str.length; i++) {
            compareTo = str[0];
            if (str[i] == compareTo) {
                count++;
            }
            compareTo = str[i];
        }
        return count;
    }

    public static void main(String[] args) {
        String[] str = {"a", "b", "a", "c", "b"};
        WordCount res = new WordCount();
        System.out.println(res.wordCount1(str));
    }
}
