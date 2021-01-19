package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOccurances {
//    Given words first and second, consider occurrences in some text of the form "first second third", where
//    second comes immediately after first, and third comes immediately after second.
//
//    For each such occurrence, add "third" to the answer, and return the answer.
//
//
//
//    Example 1:
//
//    Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
//    Output: ["girl","student"]
//    Example 2:
//
//    Input: text = "we will we will rock you", first = "we", second = "will"
//    Output: ["we","rock"]
//
//
//    Note:
//
//            1 <= text.length <= 1000
//    text consists of space separated words, where each word consists of lowercase English letters.
//1 <= first.length, second.length <= 10
//    first and second consist of lowercase English letters.

    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();
        String[] textArr = text.split(" ");
        for (int i = 0; i < textArr.length-2; i++) {
            if (textArr[i].equals(first) && textArr[i+1].equals(second)) {
                res.add(textArr[i+2]);
            }
        }
        String[] resultArr = res.toArray(new String[res.size()]);
        return resultArr;
    }

    public static void main(String[] args) {
        String text1 = "we will we will rock you", text2 = "alice is a good girl she is a good student";
        String first1 = "we", first2 = "a";
        String second1 = "will", second2 = "good";
        FindOccurances res = new FindOccurances();
        System.out.println(Arrays.toString(res.findOcurrences(text1, first1, second1)));
        System.out.println(Arrays.toString(res.findOcurrences(text2, first2, second2)));
    }
}
