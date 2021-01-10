package CodingBat;

public class StringMatch {

    //    Given 2 strings, a and b, return the number of the positions where they
    //    contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since
    //    the "xx", "aa", and "az" substrings appear in the same place in both strings.
//
//
//            stringMatch("xxcaazz", "xxbaaz") → 3
//    stringMatch("abc", "abc") → 2
//    stringMatch("abc", "axc") → 0
    public int stringMatch(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length() - 1 && i < b.length() - 1; i++) {
            if (a.substring(i, i + 2).equals(b.substring(i, i + 2)))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String a1 = "xxcaazz", b1 = "xxbaaz";
        String a2 = "abc", b2 = "abc";
        String a3 = "abc", b3 = "axc";

        StringMatch res = new StringMatch();
        System.out.println(res.stringMatch(a1, b1));
        System.out.println(res.stringMatch(a2, b2));
        System.out.println(res.stringMatch(a3, b3));
    }
}
