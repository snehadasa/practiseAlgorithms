package CodingBat;

public class MixString {

//    Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second
//    char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
//
//
//    mixString("abc", "xyz") → "axbycz"
//    mixString("Hi", "There") → "HTihere"
//    mixString("xxxx", "There") → "xTxhxexre"

    public String mixString(String a, String b) {
        String res = "",  main = "";
        if (a.length() == 0)
            return b;
        if (b.length() == 0)
            return a;
        for (int i = 0; i < a.length() && i < b.length(); i++) {
            res += a.charAt(i);
            res += b.charAt(i);
        }
        if (a.length() > b.length()) {
            main = a.substring(b.length());
        } else
        if (b.length() > a.length()) {
            main = b.substring(a.length());
        }

        return res + main;
    }

    public static void main(String[] args) {
        String a1 = "abc", a2 = "Hi", a3 = "xxxx";
        String b1 = "xyz", b2 = "There";

        MixString res = new MixString();
        System.out.println(res.mixString(a1, b1));
        System.out.println(res.mixString(a2, b2));
        System.out.println(res.mixString(a3, b2));
    }
}
