package LeetCode.Easy;

public class IsPreficOfWord {
//    Given a sentence that consists of some words separated by a single space, and a searchWord.
//
//    You have to check if searchWord is a prefix of any word in sentence.
//
//    Return the index of the word in sentence where searchWord is a prefix of this word (1-indexed).
//
//    If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
//
//    A prefix of a string S is any leading contiguous substring of S.
//
//
//
//            Example 1:
//
//    Input: sentence = "i love eating burger", searchWord = "burg"
//    Output: 4
//    Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
//            Example 2:
//
//    Input: sentence = "this problem is an easy problem", searchWord = "pro"
//    Output: 2
//    Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2
//    as it's the minimal index.
//    Example 3:
//
//    Input: sentence = "i am tired", searchWord = "you"
//    Output: -1
//    Explanation: "you" is not a prefix of any word in the sentence.
//    Example 4:
//
//    Input: sentence = "i use triple pillow", searchWord = "pill"
//    Output: 4
//    Example 5:
//
//    Input: sentence = "hello from the other side", searchWord = "they"
//    Output: -1
//
//
//    Constraints:
//
//            1 <= sentence.length <= 100
//            1 <= searchWord.length <= 10
//    sentence consists of lowercase English letters and spaces.
//    searchWord consists of lowercase English letters.

    public boolean preficWord(String str, String prefix) {
        for (int i = 0; i < str.length(); i++) {
            if (str.equals(prefix)) {
                return true;
            }
            if (str.substring(0, i).equals(prefix)) {
                return true;
            }
        }
        return false;
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        int res = 0;
        String[] sentenceArr = sentence.split(" ");
        for (int i = 0; i < sentenceArr.length; i++) {
            if (preficWord(sentenceArr[i], searchWord)) {
                res = i+1;
                break;
            }
                res = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        String sentence1 = "i use triple pillow", sentence2 = "hello from the other side", sentence3 = "love errichto jonathan dumb";
        String searchWord1 = "pill", searchWord2 = "they", searchWord3 = "dumb";
        IsPreficOfWord res = new IsPreficOfWord();
        //System.out.println(res.isPrefixOfWord(sentence1, searchWord1));
        //System.out.println(res.isPrefixOfWord(sentence2, searchWord2));
        System.out.println(res.isPrefixOfWord(sentence3, searchWord3));
    }
}
