package CodingBat;

public class Without2 {
//    Given a string, if a length 2 substring appears at both its beginning and end,
//    return a string without the substring at the beginning, so "HelloHe" yields "lloHe".
//    The substring may overlap with itself, so "Hi" yields "". Otherwise, return the original string unchanged.
//
//
//    without2("HelloHe") → "lloHe"
//    without2("HelloHi") → "HelloHi"
//    without2("Hi") → ""

    public String without2(String str) {
        if (str.length() == 2 || str == "") {
            return "";
        }
        if (str.substring(0, 2).equals(str.substring(str.length() - 2))) {
            return str.substring(2);
        }
        return str;

    }

    public static void main(String[] args) {
        String str1 = "HelloHe";
        String str2 = "HelloHi";
        String str3 = "Hi";

        Without2 res = new Without2();
        System.out.println(res.without2(str1));
        System.out.println(res.without2(str2));
        System.out.println(res.without2(str3));
    }
}
