package CodingBat;

public class DeFront {

//    Given a string, return a version without the first 2 chars. Except keep the first
//    char if it is 'a' and keep the second char if it is 'b'. The string may be any length. Harder than it looks.
//
//
//    deFront("Hello") → "llo"
//    deFront("java") → "va"
//    deFront("away") → "aay"

    public String deFront(String str) {
        if (str.length() < 2)
            return str;
        if (str.charAt(0) != 'a' && str.charAt(1) != 'b') {
            return str.substring(2);
        } else if (str.charAt(0) == 'a' && str.charAt(1) != 'b')
            return 'a' + str.substring(2);
        else if (str.charAt(0) != 'a' && str.charAt(1) == 'b')
            return 'b' + str.substring(2);
        return str;
    }

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "java";
        String str3 = "away";
        String str4 = "abc";
        String str5 = "abxyz";
        String str6 = "s";

        DeFront res = new DeFront();
        System.out.println(res.deFront(str1));
        System.out.println(res.deFront(str2));
        System.out.println(res.deFront(str3));
        System.out.println(res.deFront(str4));
        System.out.println(res.deFront(str5));
        System.out.println(res.deFront(str6));
    }
}
