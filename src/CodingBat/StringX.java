package CodingBat;

public class StringX {

//    Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed.
//
//
//    stringX("xxHxix") → "xHix"
//    stringX("abxxxcd") → "abcd"
//    stringX("xabxxxcdx") → "xabcdx"

    public String stringX(String str) {
        if (str.length() < 2) {
            return str;
        }
        if (!str.contains("x")) {
            return str;
        }
        return (str.charAt(0) + str.substring(1, str.length() - 1).replace("x", "") +
                str.charAt(str.length() - 1));
    }

//    public String stringX(String str) {
//        String result = "";
//        for (int i=0; i<str.length(); i++) {
//            // Only append the char if it is not the "x" case
//            if (!(i > 0 && i < (str.length()-1) && str.substring(i, i+1).equals("x"))) {
//                result = result + str.substring(i, i+1); // Could use str.charAt(i) here
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        String str1 = "xxhxix";
        String str2 = "xhxix";
        String str3 = "hxix";
        String str4 = "xxhi";
        String str5 = "";
        String str6 = "x";

        StringX res = new StringX();
        System.out.println(res.stringX(str1));
        System.out.println(res.stringX(str2));
        System.out.println(res.stringX(str3));
        System.out.println(res.stringX(str4));
        System.out.println(res.stringX(str5));
        System.out.println(res.stringX(str6));
    }
}
