package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class GCDofStrings {
//    For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)
//
//    Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
//
//
//
//    Example 1:
//
//    Input: str1 = "ABCABC", str2 = "ABC"
//    Output: "ABC"
//    Example 2:
//
//    Input: str1 = "ABABAB", str2 = "ABAB"
//    Output: "AB"
//    Example 3:
//
//    Input: str1 = "LEET", str2 = "CODE"
//    Output: ""
//    Example 4:
//
//    Input: str1 = "ABCDEF", str2 = "ABC"
//    Output: ""
//
//
//    Constraints:
//
//            1 <= str1.length <= 1000
//            1 <= str2.length <= 1000
//    str1 and str2 consist of English uppercase letters.

//    public String appendingrepeatedElements(String str) {
//        StringBuilder res = new StringBuilder();
//        Map<Character, Integer> countMap = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (countMap.containsKey(str.charAt(i))) {
//                int value = countMap.get(str.charAt(i));
//                countMap.put(str.charAt(i), 1 + value);
//            } else {
//                countMap.put(str.charAt(i), 1);
//            }
//        }
//
//        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
//            if (entry.getValue() > 1) {
//                res.append(entry.getKey());
//            }
//        }
//
//        return res.toString();
//    }
//
//    public boolean ifStrHasrepeatedElements(String str) {
//        StringBuilder res = new StringBuilder();
//        Map<Character, Integer> countMap = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (countMap.containsKey(str.charAt(i))) {
//                int value = countMap.get(str.charAt(i));
//                countMap.put(str.charAt(i), 1 + value);
//            } else {
//                countMap.put(str.charAt(i), 1);
//            }
//        }
//
//        List<Integer> ifYes = new ArrayList<>();
//        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
//            if (entry.getValue() < 2) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public String gcdOfStrings1(String str1, String str2) {
//        String s1 = "", s2 = "", res = "";
//        if (ifStrHasrepeatedElements(str1)) {
//            s1 = appendingrepeatedElements(str1);
//        } else {
//            s1 = str1;
//        }
//        if (ifStrHasrepeatedElements(str2)) {
//            s2 = appendingrepeatedElements(str2);
//        } else {
//            s2 = str2;
//        }
//
//        if (s1.equals(s2)) {
//            res = s1;
//        }
//        return res;
//    }
//
//    public String containsSubstring(String str, int n) {
//        String sub = "";
//        StringBuilder res = new StringBuilder();
//        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            sub = str.substring(0, n);
//
//            if (str.substring(n).contains(sub)) {
//                count++;
//            }
//        }
//        if (count >= 2) {
//            res.append(sub);
//        }
//        return res.toString();
//    }
//
//    public String gcdOfStrings(String str1, String str2) {
//        String s1 = "", s2 = "", s = "", substr1 = "", substr2 = "";
//        StringBuilder sub1 = new StringBuilder();
//        StringBuilder sub2 = new StringBuilder();
//
//        if (str1.length() > str2.length()) {
//            for (int i = 0; i < str1.length(); i++) {
//                if (str1.contains(str2) && str1.length() >= 2* str2.length()) {
//                    substr1 = str1.substring(0, str2.length());
//                } else {
//                    sub1.append(str1.charAt(i));
//
//                    s1 = str1.replace(sub1.toString(), "");
//
//                    if (s1.length() == 0) {
//                        substr1 = sub1.toString();
//                        break;
//                    }
//                }
//            }
//        } else {
//            substr1 = str1;
//        }
//        if (str2.length() > str1.length()) {
//            for (int i = 0; i < str2.length(); i++) {
//                if (str2.contains(str1) && str2.length() >= 2* str1.length()) {
//                    substr2 = str2.substring(0, str1.length());
//                } else {
//                    sub2.append(str2.charAt(i));
//
//                    s2 = str2.replace(sub2.toString(), "");
//
//                    if (s2.length() == 0) {
//                        substr2 = sub2.toString();
//                        break;
//                    }
//                }
//            }
//        } else {
//            substr2 = str2;
//        }
//
//        if (substr1.equals(substr2)) {
//            s = substr1;
//        }
//        return s;
//    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

   boolean willSmallStrDivide(String s, String t) {
       if (s.length() % t.length() != 0) {
           return false;
       }

       for (int i = 0; i < s.length(); i+= t.length()) {
           if (!s.substring(i, i+t.length()).equals(t)) {
               return false;
           }
       }
       return true;
   }

    public String gcdOfStrings(String str1, String str2) {
        int gcd = gcd(str1.length(), str2.length());

        String t = str1.substring(0, gcd);
        if (willSmallStrDivide(str1, t) && willSmallStrDivide(str2, t)) {
            return t;
        }
        return "";
    }

    public String gcdOfStrings1(String str1, String str2) {
       int minStringLen = Math.min(str1.length(), str2.length());

       for (int i = minStringLen; i>= 0; i--) {
           String t = str1.substring(0,i);
           if (willSmallStrDivide(str1, t) && willSmallStrDivide(str2, t)) {
               return t;
           }
       }
       return "";
    }

        public static void main(String[] args) {
        String str1 = "ABABABAB", str2 = "ABAB";
        int n = 2;
        GCDofStrings res = new GCDofStrings();
        //System.out.println(res.ifStrHasrepeatedElements(str1));
        //System.out.println(res.appendingrepeatedElements(str1));
        System.out.println(res.gcdOfStrings(str1, str2));
        //System.out.println(res.containsSubstring(str1, n));
    }
}
