package CodingBat;

import java.lang.reflect.Array;

public class ZipZap {

//    Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a
//    string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
//
//
//    zipZap("zipXzap") → "zpXzp"
//    zipZap("zopozop") → "zpzp"
//    zipZap("zzzopzop") → "zzzpzp"

    public String zipZap(String str) {
//        StringBuilder sb = new StringBuilder(str);
//        String resultString = sb.toString();
        String res = "";
        boolean shouldReplace [] = new  boolean[str.length()];
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'z' && str.charAt(i+2) == 'p') {
                shouldReplace[i+1] = true;
            }
        }
        for(int i = 0; i < str.length(); i++) {
            if (!shouldReplace[i]) {
                res += str.charAt(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str1 = "zipXzap";
        String str2 = "zop0ozop";
        String str3 = "zzzopzop";

        ZipZap res = new ZipZap();
        System.out.println(res.zipZap(str1));
        System.out.println(res.zipZap(str2));
        System.out.println(res.zipZap(str3));
    }
}
