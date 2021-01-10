package CodingBat;

public class FrontTimes {
//    Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front;
//
//
//    frontTimes("Chocolate", 2) → "ChoCho"
//    frontTimes("Chocolate", 3) → "ChoChoCho"
//    frontTimes("Abc", 3) → "AbcAbcAbc"

    public String frontTimes(String str, int n) {
        String res = "";

        if (str.length() < n) {
            for (int i = 0; i < n; i++) {
                res += str;
            }
        }
        if (str.length() >= n) {
            for (int i = 0; i < n; i++) {
                res += str.substring(0, 3);
            }
        }
        // for (int i = 0; i < n; i++) {
        //   if (str.length() < n) {
        //     res += str;
        //   }
        //   res += str.substring(0, 3);
        // }
        return res;
    }

//    public String frontTimes(String str, int n) {
//        int frontLen = 3;
//        if (frontLen > str.length()) {
//            frontLen = str.length();
//        }
//        String front = str.substring(0, frontLen);
//
//        String result = "";
//        for (int i=0; i<n; i++) {
//            result = result + front;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        String str1 = "chocolate", str2 = "chocolate", str3 = "abc";
        int n1 = 2, n2 = 3, n3 = 3;
        FrontTimes res = new FrontTimes();
        System.out.println(res.frontTimes(str1, n1));
        System.out.println(res.frontTimes(str2, n2));
        System.out.println(res.frontTimes(str3, n3));
    }
}
