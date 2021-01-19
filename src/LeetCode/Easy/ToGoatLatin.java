package LeetCode.Easy;

import java.util.Arrays;

public class ToGoatLatin {
//    A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
//
//    We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
//
//    The rules of Goat Latin are as follows:
//
//    If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
//    For example, the word 'apple' becomes 'applema'.
//
//    If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
//    For example, the word "goat" becomes "oatgma".
//
//    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
//    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
//    Return the final sentence representing the conversion from S to Goat Latin.
//
//
//
//            Example 1:
//
//    Input: "I speak Goat Latin"
//    Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
//    Example 2:
//
//    Input: "The quick brown fox jumped over the lazy dog"
//    Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
//
//
//    Notes:
//
//    S contains only uppercase, lowercase and spaces. Exactly one space between each word.
//            1 <= S.length <= 150.

    String singleToGoatLatin(String s) {
        StringBuilder newS = new StringBuilder();
        if (s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o' || s.charAt(0) == 'u') {
            newS.append(s);
            newS.append("ma");
        } else
            newS.append(s.substring(1));
        newS.append(s.charAt(0));
        newS.append("ma");

        return newS.toString();
    }

    public String toGoatLatin(String S) {
        String[] strArr = S.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = 0 ; i < strArr.length; i++) {
            res.append(singleToGoatLatin(strArr[i]));
            for (int j = 0; j < i +1; j++) {
                res.append('a');
            }
            if (i != strArr.length - 1) {
                res.append(" ");
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String S = "I speak Goat Latin";
        ToGoatLatin res = new ToGoatLatin();
        System.out.println(res.toGoatLatin(S));
        //System.out.println(res.singleToGoatLatin("bowl"));
        //System.out.println(Arrays.toString(res.toGoatLatin(S)));
    }
}
