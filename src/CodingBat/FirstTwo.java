package CodingBat;

public class FirstTwo {

    //    Given a string, return the string made of its first two chars, so the String "Hello" yields "He".
//    If the string is shorter than length 2, return whatever there is, so "X" yields "X",
//    and the empty string "" yields the empty string "". Note that str.length() returns the length of a string.
//
//
//    firstTwo("Hello") → "He"
//    firstTwo("abcdefg") → "ab"
//    firstTwo("ab") → "ab"
    public String firstTwo(String str) {
        if (str.equals("")) {
            return "";
        } else if (str.length() <= 2) {
            return str;
        } else
        return str.substring(0, 2);
    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "";
        String str3 = "mo";
        FirstTwo res = new FirstTwo();
        System.out.println(res.firstTwo(str1));
        System.out.println(res.firstTwo(str2));
        System.out.println(res.firstTwo(str3));
    }
}
