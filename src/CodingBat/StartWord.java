package CodingBat;

public class StartWord {
//    Given a string and a second "word" string, we'll say that the word matches the string
//    if it appears at the front of the string, except its first char does not need to match exactly.
//    On a match, return the front of the string, or otherwise return the empty string. So, so with
//    the string "hippo" the word "hi" returns "hi" and "xip" returns "hip". The word will be at least length 1.
//
//
//    startWord("hippo", "hi") → "hi"
//    startWord("hippo", "xip") → "hip"
//    startWord("hippo", "i") → "h"

    public String startWord(String str, String word) {
        int sl = str.length();
        int wl = word.length();
//        int sw = sl - wl;
//        //System.out.println(str.substring(0, (sl - sw)));
//        if (wl < 1) {
//            return "";
//        }
//        if (wl == 1) {
//            return "h";
//        }else
//        if (str.charAt(0) == word.charAt(0)) {
//            return word;
//        } else
////        else if (wl >= 2 && word.equalsIgnoreCase(str.substring(0, sw))) {
////            return str.charAt(0) + word.substring(1);
////        }
//        if (wl >= 2 && sl >= 2 && str.substring(1, (sl - sw)).
//                equals(word.substring(1))) {
//            return str.charAt(0) + word.substring(1);
//        }
//        return "";

        if (sl >= wl && str.substring(1, wl).equals(str.substring(1))) {
            return str.substring(0, wl);
        }
        return "";

    }

    public static void main(String[] args) {
        String str1 = "hello", word1 = "hi";
        String str2 = "hippo", word2 = "hip";
        String str3 = "hippo", word3 = "h";
        String str4 = "hippo", word4 = "xippo";
        String str5 = "kitten", word5 = "cit";
        String str6 = "", word6 = "i";

        StartWord res = new StartWord();
        System.out.println(res.startWord(str1, word1));
        System.out.println(res.startWord(str2, word2));
        System.out.println(res.startWord(str3, word3));
        System.out.println(res.startWord(str4, word4));
        System.out.println(res.startWord(str5, word5));
        System.out.println(res.startWord(str6, word6));
    }
}
