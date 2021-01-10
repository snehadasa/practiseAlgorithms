package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
//    International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as
//    follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
//
//    For convenience, the full table for the 26 letters of the English alphabet is given below:
//        [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
//        "...","-","..-","...-",".--","-..-","-.--","--.."]
//    Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For
//    example, "cab" can be written as "-.-..--...", (which is the concatenation "-.-." + ".-" + "-..."). We'll call such
//    a concatenation, the transformation of a word.
//
//    Return the number of different transformations among all words we have.
//
//            Example:
//    Input: words = ["gin", "zen", "gig", "msg"]
//    Output: 2
//    Explanation:
//    The transformation of each word is:
//            "gin" -> "--...-."
//            "zen" -> "--...-."
//            "gig" -> "--...--."
//            "msg" -> "--...--."
//
//    There are 2 different transformations, "--...-." and "--...--.".
//    Note:
//
//    The length of words will be at most 100.
//    Each words[i] will have length in range [1, 12].
//    words[i] will only consist of lowercase letters.


    public String getMorseCode(char c) {
        switch (c) {
            case 'a': {
                return ".-";
            }
            case 'b': {
                return "-...";

            }
            case 'c': {
                return "-.-.";

            }
            case 'd': {
                return "-..";

            }
            case 'e': {
                return ".";

            }
            case 'f': {
                return "..-.";

            }
            case 'g': {
                return "--.";

            }
            case 'h': {
                return "....";

            }
            case 'i': {
                return "..";

            }
            case 'j': {
                return ".---";

            }
            case 'k': {
                return "-.-";

            }
            case 'l': {
                return ".-..";

            }
            case 'm': {
                return "--";

            }
            case 'n': {
                return "-.";

            }
            case 'o': {
                return "---";

            }
            case 'p': {
                return ".--.";

            }
            case 'q': {
                return "--.-";

            }
            case 'r': {
                return ".-.";

            }
            case 's': {
                return "...";

            }
            case 't': {
                return "-";

            }
            case 'u': {
                return "..-";

            }
            case 'v': {
                return "...-";

            }
            case 'w': {
                return ".--";

            }
            case 'x': {
                return "-..-";

            }
            case 'y': {
                return "-.--";

            }
            case 'z': {
                return "--..";
            }
        }
        return "";
    }

    public String getConcatedTransformation(String word) {
        String transformedMorse = "";
        char[] wordC = word.toCharArray();
        for (int i = 0; i < wordC.length; i++) {
            transformedMorse += getMorseCode(wordC[i]);
        }
        return transformedMorse;
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> wordsMorse = new HashSet<>();
        for (String wordM:words) {
            wordsMorse.add(getConcatedTransformation(wordM));
        }
        return wordsMorse.size();
    }

    public static void main(String[] args) {
        UniqueMorseRepresentations res = new UniqueMorseRepresentations();
        String[] word = {"gin", "zen", "gig", "msg"};
        System.out.println(res.uniqueMorseRepresentations(word));
    }
}
