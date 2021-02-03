package LeetCode.Easy;

public class DetectCapitalUse {
//    Given a word, you need to judge whether the usage of capitals in it is right or not.
//
//    We define the usage of capitals in a word to be right when one of the following cases holds:
//
//    All letters in this word are capitals, like "USA".
//    All letters in this word are not capitals, like "leetcode".
//    Only the first letter in this word is capital, like "Google".
//    Otherwise, we define that this word doesn't use capitals in a right way.
//
//
//    Example 1:
//
//    Input: "USA"
//    Output: True
//
//
//    Example 2:
//
//    Input: "FlaG"
//    Output: False
//
//
//    Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

    public boolean upperCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
                return false;
            }
        }
        return true;
    }

    public boolean lowerCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public boolean detectCapitalUse(String word) {

        if (word.isEmpty()) {
            return true;
        } else if (upperCase(word)) {
            return true;
        } else if (lowerCase(word)) {
            return true;
        } else if (Character.isUpperCase(word.charAt(0)) && lowerCase(word.substring(1))) {
            return true;
        }
        return false;
    }

    public boolean detectCapitalUse1(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }

    public static void main(String[] args) {
        String s = "Sneha";
        DetectCapitalUse res = new DetectCapitalUse();
        System.out.println(res.detectCapitalUse1(s));
    }
}
