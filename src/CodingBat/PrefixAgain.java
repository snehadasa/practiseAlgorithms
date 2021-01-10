package CodingBat;

public class PrefixAgain {

//    Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear
//    somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().
//
//
//    prefixAgain("abXYabc", 1) → true
//    prefixAgain("abXYabc", 2) → true
//    prefixAgain("abXYabc", 3) → false

    public boolean prefixAgain(String str, int n) {
        String sub = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            sub = str.substring(0, n);

            if (str.substring(n).contains(sub)) {
                count++;
            }
        }
        if (count >= 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abXYabc";
        int n1 = 1, n2 = 2, n3 = 3;
        PrefixAgain res = new PrefixAgain();
        System.out.println(res.prefixAgain(str, n1));
        System.out.println(res.prefixAgain(str, n2));
        System.out.println(res.prefixAgain(str, n3));
    }
}
