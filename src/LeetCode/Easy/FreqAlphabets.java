package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class FreqAlphabets {
//    Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
//
//    Characters ('a' to 'i') are represented by ('1' to '9') respectively.
//            Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
//    Return the string formed after mapping.
//
//    It's guaranteed that a unique mapping will always exist.
//
//
//
//    Example 1:
//
//    Input: s = "10#11#12"
//    Output: "jkab"
//    Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//    Example 2:
//
//    Input: s = "1326#"
//    Output: "acz"
//    Example 3:
//
//    Input: s = "25#"
//    Output: "y"
//    Example 4:
//
//    Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
//    Output: "abcdefghijklmnopqrstuvwxyz"
//
//
//    Constraints:
//
//            1 <= s.length <= 1000
//    s[i] only contains digits letters ('0'-'9') and '#' letter.
//    s will be valid string such that mapping is always possible.

    public String freqAlphabets(String s) {
        Character c =  ' ';
        StringBuilder res = new StringBuilder();
        Map<String, Character> alphabets = new HashMap<>();

        //for (char ch = 'a'; ch <= 'i'; ++ch) {
            alphabets.put("0", ' ');
            alphabets.put("1", 'a');
            alphabets.put("2", 'b');
            alphabets.put("3", 'c');
            alphabets.put("4", 'd');
            alphabets.put("5", 'e');
            alphabets.put("6", 'f');
            alphabets.put("7", 'g');
            alphabets.put("8", 'h');
            alphabets.put("9", 'i');
            alphabets.put("10#", 'j');
            alphabets.put("11#", 'k');
            alphabets.put("12#", 'l');
            alphabets.put("13#", 'm');
            alphabets.put("14#", 'n');
            alphabets.put("15#", 'o');
            alphabets.put("16#", 'p');
            alphabets.put("17#", 'q');
            alphabets.put("18#", 'r');
            alphabets.put("19#", 's');
            alphabets.put("20#", 't');
            alphabets.put("21#", 'u');
            alphabets.put("22#", 'v');
            alphabets.put("23#", 'w');
            alphabets.put("24#", 'x');
            alphabets.put("25#", 'y');
            alphabets.put("26#", 'z');

//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '#') {
//                c = alphabets.get(s.substring(i - 2, i+1));
//                res.delete(res.length() - 2, res.length());
//                res.append(c);
//            } else {
//                c = alphabets.get(s.substring(i, i + 1));
//                res.append(c);
//            }
//        }

        for (int i = 0 ; i < s.length(); i ++) {
            if (i < s.length() - 2 && s.charAt(i+2) == '#') {
                res.append(alphabets.get(s.substring(i, i+3)));
                i += 2;
            } else {
                res.append(alphabets.get(s.substring(i, i+1)));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "1211#9";
//        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        FreqAlphabets res = new FreqAlphabets();
        System.out.println(res.freqAlphabets(s));
    }
}
