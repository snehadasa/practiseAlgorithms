package CodingBat;

public class DoubleChar {

//    Given a string, return a string where for every char in the original, there are two chars.
//
//
//            doubleChar("The") → "TThhee"
//    doubleChar("AAbb") → "AAAAbbbb"
//    doubleChar("Hi-There") → "HHii--TThheerree"

    public String doubleChar(String str) {
        char[] chars = str.toCharArray();
        String res = "";
        String prev = "";
        for (int i = 0; i < str.length(); i++) {
            prev = str.substring(i, i+1) + str.substring(i, i+1);
            res += prev;
        }
        return res;
    }

//    public String doubleChar(String str) {
//        String result = "";
//        for (int i = 0; i < str.length(); i++) {
//            result = result + str.charAt(i) + str.charAt(i);
//            // Alternately:
//            // result = result + str.substring(i, i+1) + str.substring(i, i+1);
//        }
//        return result;
//    }

    public static void main(String[] args) {
        String str1 = "code";
        String str2 = "hi";
        String str3 = "abc";
        String str4 = "";
        String str5 = "ab";
        String str6 = "a";

        DoubleChar res = new DoubleChar();
        System.out.println(res.doubleChar(str1));
        System.out.println(res.doubleChar(str2));
        System.out.println(res.doubleChar(str3));
        System.out.println(res.doubleChar(str4));
        System.out.println(res.doubleChar(str5));
        System.out.println(res.doubleChar(str6));
    }
}
