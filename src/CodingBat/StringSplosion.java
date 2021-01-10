package CodingBat;

public class StringSplosion {
//    Given a non-empty string like "Code" return a string like "CCoCodCode".
//
//
//    stringSplosion("Code") → "CCoCodCode"
//    stringSplosion("abc") → "aababc"
//    stringSplosion("ab") → "aab"
    public String stringSplosion(String str) {
        char[] chars = str.toCharArray();
        String prev = "";
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            res += chars[i];
            prev += res;
        }
        return prev;
    }

//    public String stringSplosion(String str) {
//        String result = "";
//        // On each iteration, add the substring of the chars 0..i
//        for (int i=0; i<str.length(); i++) {
//            result = result + str.substring(0, i+1);
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

        StringSplosion res = new StringSplosion();
        System.out.println(res.stringSplosion(str1));
        System.out.println(res.stringSplosion(str2));
        System.out.println(res.stringSplosion(str3));
        System.out.println(res.stringSplosion(str4));
        System.out.println(res.stringSplosion(str5));
        System.out.println(res.stringSplosion(str6));
    }
}
