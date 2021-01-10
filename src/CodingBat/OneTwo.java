package CodingBat;

public class OneTwo {

    //    Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields
//    "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". Ignore any group of
//    fewer than 3 chars at the end.
//
//
//    oneTwo("abc") → "bca"
//    oneTwo("tca") → "cat"
//    oneTwo("tcagdo") → "catdoghg"

    public String oneTwo(String str) {
        String res = "";
        if (str.length() < 3) {
            return "";
        }
        for (int i = 0; i < str.length() - 2; i+=3) {
            //if (str.length() < 4) {
                res += str.substring(i + 1, i + 3) + str.charAt(i);
           // }
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "abcgh";
        String str2 = "tca";
        String str3 = "tcadgo";

        OneTwo res = new OneTwo();
        System.out.println(res.oneTwo(str1));
        System.out.println(res.oneTwo(str2));
        System.out.println(res.oneTwo(str3));
    }
}
