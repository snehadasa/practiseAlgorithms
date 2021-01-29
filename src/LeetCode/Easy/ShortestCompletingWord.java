package LeetCode.Easy;

import java.util.*;

public class ShortestCompletingWord {
//    Given a string licensePlate and an array of strings words, find the shortest completing word in words.
//
//    A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in
//    licensePlate, and treat letters as case insensitive. If a letter appears more than once in licensePlate,
//    then it must appear in the word the same number of times or more.
//
//    For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice.
//    Possible completing words are "abccdef", "caaacab", and "cbca".
//
//    Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple shortest
//    completing words, return the first one that occurs in words.
//
//
//
//            Example 1:
//
//    Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
//    Output: "steps"
//    Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
//            "step" contains 't' and 'p', but only contains 1 's'.
//            "steps" contains 't', 'p', and both 's' characters.
//"stripe" is missing an 's'.
//            "stepple" is missing an 's'.
//    Since "steps" is the only word containing all the letters, that is the answer.
//            Example 2:
//
//    Input: licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
//    Output: "pest"
//    Explanation: licensePlate only contains the letter 's'. All the words contain 's', but among these "pest",
//    "stew", and "show" are shortest. The answer is "pest" because it is the word that appears earliest of the 3.
//    Example 3:
//
//    Input: licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug",
//    "prevent","writer","old"]
//    Output: "husband"
//    Example 4:
//
//    Input: licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive",
//    "money","tax","thus"]
//    Output: "enough"
//    Example 5:
//
//    Input: licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never",
//    "wonder","simple","thought","use"]
//    Output: "simple"
//
//
//    Constraints:
//
//            1 <= licensePlate.length <= 7
//    licensePlate contains digits, letters (uppercase or lowercase), or space ' '.
//            1 <= words.length <= 1000
//            1 <= words[i].length <= 15
//    words[i] consists of lower case English letters.

    public boolean containsCharacter(Map<Character, Integer> wordToChar, String str) {
        char[] strArr = str.toCharArray();
        Map<Character, Integer> mapOfWord = new HashMap<>();

        for (int i = 0; i < strArr.length; i++) {
            if (Character.isLetter(strArr[i])) {
                if (mapOfWord.containsKey(strArr[i])) {
                    int value = mapOfWord.get(strArr[i]);
                    mapOfWord.put(strArr[i], 1+value);
                }
                mapOfWord.put(strArr[i], 1);
            }
        }

        for (Character ch : wordToChar.keySet()) {
            if (!wordToChar.containsKey(ch) || wordToChar.get(ch) < mapOfWord.get(ch)) {
                return false;
            }
        }
        return true;

    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] licensePlateToChar = licensePlate.toCharArray();
        Map<Character, Integer> mapOfCount = new HashMap<>();

        for (int i = 0; i < licensePlateToChar.length; i++) {
            if (Character.isLetter(licensePlateToChar[i])) {
                if (mapOfCount.containsKey(licensePlateToChar[i])) {
                    int value = mapOfCount.get(licensePlateToChar[i]);
                    mapOfCount.put(licensePlateToChar[i], 1 + value);
                } else
                    mapOfCount.put(licensePlateToChar[i], 1);
            }
        }

        String shortestWord = "";
        for (String word: words) {
            if (containsCharacter(mapOfCount, word)) {
                if (shortestWord.equals("") || shortestWord.length() > word.length()) {
                    shortestWord = word;
                }
            }
        }
        return shortestWord;
    }

        public static void main(String[] args) {
        String licenseplate1 = "iMSlpe4";
        String licenseplate2 = "1s3 PST";
        String licenseplate3 = "1s3 456";
        String[] words1 = {"claim","consumer","student","camera","public","never", "wonder","simple","thought","use"};
        String[] words2 = {"step","steps","stripe","stepple"};
        String[] words3 = {"looks","pest","stew","show"};
        ShortestCompletingWord res = new ShortestCompletingWord();
        System.out.println(res.shortestCompletingWord(licenseplate1, words1));
        System.out.println(res.shortestCompletingWord(licenseplate2, words2));
        System.out.println(res.shortestCompletingWord(licenseplate3, words3));
        //System.out.println(res.singleWordIfContains(licenseplate, "simpley"));
    }
}
