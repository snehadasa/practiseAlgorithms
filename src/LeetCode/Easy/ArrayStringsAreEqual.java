package LeetCode.Easy;

public class ArrayStringsAreEqual {
//    Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
//
//    A string is represented by an array if the array elements concatenated in order forms the string.
//
//            Example 1:
//    Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
//    Output: true
//    Explanation:
//    word1 represents string "ab" + "c" -> "abc"
//    word2 represents string "a" + "bc" -> "abc"
//    The strings are the same, so return true.
//    Example 2:
//
//    Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
//    Output: false
//    Example 3:
//
//    Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//    Output: true
//
//
//    Constraints:
//
//            1 <= word1.length, word2.length <= 103
//            1 <= word1[i].length, word2[i].length <= 103
//            1 <= sum(word1[i].length), sum(word2[i].length) <= 103
//    word1[i] and word2[i] consist of lowercase letters.

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String res1 = "";
        String res2 = "";
        for (int i = 0; i < word1.length; i++) {
            if (word1.length != 0) {
                res1 += word1[i];
            }
        }
        for (int i = 0; i < word2.length; i++) {
            if (word2.length != 0) {
                res2 += word2[i];
            }
        }
        if (res1.equals(res2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"ab", "c"};

        ArrayStringsAreEqual res = new ArrayStringsAreEqual();
        System.out.println(res.arrayStringsAreEqual(word1, word2));
    }
}
