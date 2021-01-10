package CodingBat;

public class StringBits {

    //    Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
//
//
//    stringBits("Hello") → "Hlo"
//    stringBits("Hi") → "H"
//    stringBits("Heeololeo") → "Hello"
    public String stringBits(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i+=2) {
            char n = str.charAt(i);
            sb.append(n);
        }

        return sb.toString();
    }

//    public String stringBits(String str) {
//        String result = "";
//        // Note: the loop increments i by 2
//        for (int i=0; i<str.length(); i+=2) {
//            result = result + str.substring(i, i+1);
//            // Alternately could use str.charAt(i)
//        }
//        return result;
//    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hi";
        String str3 = "heeololeo";
        String str4 = "";
        String str5 = "xabcxx";
        String str6 = "abxxxcd";

        StringBits res = new StringBits();
        System.out.println(res.stringBits(str1));
        System.out.println(res.stringBits(str2));
        System.out.println(res.stringBits(str3));
        System.out.println(res.stringBits(str4));
        System.out.println(res.stringBits(str5));
        System.out.println(res.stringBits(str6));
    }
}
