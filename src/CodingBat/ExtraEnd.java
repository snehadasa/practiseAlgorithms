package CodingBat;

public class ExtraEnd {

//    Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string length will be at least 2.
//
//
//    extraEnd("Hello") → "lololo"
//    extraEnd("ab") → "ababab"
//    extraEnd("Hi") → "HiHiHi"

    public String extraEnd(String str) {
        String s = "null";
        if (str.length() < 2) {
            return str + str + str;
        }
        if (str.length() >= 2) {
            s = str.substring((str.length() - 2));
        }
        return s + s + s;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "a";
        String s3 = "ab";
        ExtraEnd res = new ExtraEnd();
        System.out.println(res.extraEnd(s1));
        System.out.println(res.extraEnd(s2));
        System.out.println(res.extraEnd(s3));
    }
}
