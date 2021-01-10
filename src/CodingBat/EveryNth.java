package CodingBat;

public class EveryNth {

//    Given a non-empty string and an int N, return the string made starting with char 0,
//    and then every Nth char of the string. So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more.
//
//
//    everyNth("Miracle", 2) → "Mrce"
//    everyNth("abcdefg", 2) → "aceg"
//    everyNth("abcdefg", 3) → "adg"

    public String everyNth(String str, int n) {
        String newStr = "";
        for (int i = 0; i <= str.length() - 1; i++) {
            if (i % n == 0) {
                newStr += str.charAt(i);
            }
        }
        return newStr;
    }

    public static void main(String[] args) {
        String str1 = "miracle", str2 = "abcdefg", str3 = "bangalore";
        int n1 = 2, n2 = 2, n3 = 3;
        EveryNth res = new EveryNth();
        System.out.println(res.everyNth(str1, n1));
        System.out.println(res.everyNth(str2, n2));
        System.out.println(res.everyNth(str3, n3));
    }

//    public String everyNth(String str, int n) {
//        String result = "";
//
//        // Look at every nth char
//        for (int i=0; i<str.length(); i = i + n) {
//            result = result + str.charAt(i);
//        }
//        return result;
//    }
}
