package LeetCode.Easy;

import java.util.*;

public class UncommonFromSentences {
//    We are given two sentences A and B.  (A sentence is a string of space separated words.
//    Each word consists only of lowercase letters.)
//
//    A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
//
//    Return a list of all uncommon words.
//
//    You may return the list in any order.
//
//
//
//            Example 1:
//
//    Input: A = "this apple is sweet", B = "this apple is sour"
//    Output: ["sweet","sour"]
//    Example 2:
//
//    Input: A = "apple apple", B = "banana"
//    Output: ["banana"]

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap();
        List<String> uniqueElements = new ArrayList<>();
        String[] newA = A.split(" ");
        String[] newB = B.split(" ");

        for (int i = 0; i < newA.length; i++) {
            if (map.containsKey(newA[i])) {
                int value = map.get(newA[i]);
                map.put(newA[i], 1+value);
            } else
                map.put(newA[i], 1);
        }
        for (int i = 0; i < newB.length; i++) {
            if (map.containsKey(newB[i])) {
                int value = map.get(newB[i]);
                map.put(newB[i], 1+value);
            } else
                map.put(newB[i], 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                uniqueElements.add(entry.getKey());
            }
        }

        String[] result = new String[uniqueElements.size()];
        for (int i = 0; i < uniqueElements.size(); i++) {
            result[i] = uniqueElements.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";

        UncommonFromSentences res = new UncommonFromSentences();
        System.out.println(Arrays.toString(res.uncommonFromSentences(A, B)));
    }
}
