package CodingBat;

public class WithoutX2 {
    //    Given a string, if one or both of the first 2 chars is 'x', return the string without those 'x' chars, and otherwise return the string unchanged. This is a little harder than it looks.
//
//
//    withoutX2("xHi") → "Hi"
//    withoutX2("Hxi") → "Hi"
//    withoutX2("Hi") → "Hi"

    public String withoutX2(String str) {
        if (str.length() <= 2) {
            return str.replace("x", "");
        }
        return str.substring(0,2).replace("x", "") + str.substring(2);




//        if (str.length() == 0) {
//            return str;
//        }
//        String firstSubString = str.substring(0, Math.min(str.length(), 2));
//        firstSubString.replace("x", "");
//        return firstSubString + (str.length() > 2 ? str.substring(2) : "");

//         if (str.length() >= 2 && (str.charAt(0) == 'x' || str.charAt(1) == 'x')) {
//           return str.replace("x", "");
//         }
//         return str;
    }

    public static void main(String[] args) {
        String str1 = "xhix";
        String str2 = "hxi";
        String str3 = "hi";
        String str4 = "xaxb";
        String str5 = "";
        String str6 = "xhxllo";

        WithoutX res = new WithoutX();
        System.out.println(res.withoutX(str1));
        System.out.println(res.withoutX(str2));
        System.out.println(res.withoutX(str3));
        System.out.println(res.withoutX(str4));
        System.out.println(res.withoutX(str5));
        System.out.println(res.withoutX(str6));
    }
}
