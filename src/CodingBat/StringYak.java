package CodingBat;

public class StringYak {

//    Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak"
//    are removed, but the "a" can be any char. The "yak" strings will not overlap.
//
//
//    stringYak("yakpak") → "pak"
//    stringYak("pakyak") → "pak"
//    stringYak("yak123ya") → "123ya"]

    public String stringYak(String str) {
        if (str.length() >=3 && str.contains("yak")) {
            return str.substring(0, str.length()).replace("yak", "");
        }
        return "";
//        String res = "";
//        for (int i = 0; i < str.length(); i++) {
//            if (i+2<str.length() && str.charAt(i) == 'y' && str.charAt(i + 2) == 'k') {
//                i = i + 2;
//            } else
//                res += str.charAt(i);
//        }
//        return res;
    }

    public static void main(String[] args) {
        String str1 = "yokpak";
        String str2 = "pakyak";
        String str3 = "yak123ya";
        String str4 = "hiyakhi";
        String str5 = "";
        String str6 = "y";

        StringYak res = new StringYak();
        System.out.println(res.stringYak(str1));
        System.out.println(res.stringYak(str2));
        System.out.println(res.stringYak(str3));
        System.out.println(res.stringYak(str4));
        System.out.println(res.stringYak(str5));
        System.out.println(res.stringYak(str6));
    }

}
