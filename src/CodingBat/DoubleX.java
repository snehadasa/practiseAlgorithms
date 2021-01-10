package CodingBat;

public class DoubleX {

//    Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
//
//
//    doubleX("axxbb") → true
//    doubleX("axaxax") → false
//    doubleX("xxxxx") → true
    boolean doubleX(String str) {
        // for (int i = 0; i < str.length() - 1; i++) {
        //   if (str.substring(i).equals("x")) {
        //     return (str.substring(i+1).equals("xx"));
        //   }
        // }
        // return true;

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'x') {
                return (chars[i+1] == 'x');
            }
        }
        return false;
    }

//    boolean doubleX(String str) {
//        int i = str.indexOf("x");
//        if (i == -1) return false; // no "x" at all
//
//        // Is char at i+1 also an "x"?
//        if (i+1 >= str.length()) return false; // check i+1 in bounds?
//        return str.substring(i+1, i+2).equals("x");
//
//        // Another approach -- .startsWith() simplifies the logic
//        // String x = str.substring(i);
//        // return x.startsWith("xx");
//    }

    public static void main(String[] args) {
        String str1 = "abcxx";
        String str2 = "xxx";
        String str3 = "xxxx";
        String str4 = "";
        String str5 = "xabcxx";
        String str6 = "abxxxcd";

        DoubleX res = new DoubleX();
        System.out.println(res.doubleX(str1));
        System.out.println(res.doubleX(str2));
        System.out.println(res.doubleX(str3));
        System.out.println(res.doubleX(str4));
        System.out.println(res.doubleX(str5));
        System.out.println(res.doubleX(str6));
    }
}
