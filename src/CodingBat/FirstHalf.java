package CodingBat;

public class FirstHalf {

//    Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
//
//
//    firstHalf("WooHoo") → "Woo"
//    firstHalf("HelloThere") → "Hello"
//    firstHalf("abcdef") → "abc"

    public String firstHalf(String str) {
        return str.substring(0, str.length() / 2);
    }

    public static void main(String[] args) {
        String str1 = "WooHoo";
        String str2 = "helloThere";
        String str3 = "";
        FirstHalf res = new FirstHalf();
        System.out.println(res.firstHalf(str1));
        System.out.println(res.firstHalf(str2));
        System.out.println(res.firstHalf(str3));
    }
}
