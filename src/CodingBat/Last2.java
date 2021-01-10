package CodingBat;

public class Last2 {

//    Given a string, return the count of the number of times that a substring length 2
//    appears in the string and also as the last 2 chars of the string, so
//    "hixxxhi" yields 1 (we won't count the end substring).
//
//
//    last2("hixxhi") → 1
//    last2("xaxxaxaxx") → 1
//    last2("axxxaaxx") → 2

    public int last2(String str) {
        int count = 0;
        String lastTwoChars = str.substring(str.length() - 2);
        for (int i=0; i<str.length() - 2; i++) {
            if (lastTwoChars.equals(str.substring(i, i+2))) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str1 = "abcxx";
        String str2 = "xxx";
        String str3 = "xxxx";
        String str4 = "";
        String str5 = "xabcxx";
        String str6 = "abxxxcd";

        Last2 res = new Last2();
        System.out.println(res.last2(str1));
        System.out.println(res.last2(str2));
        System.out.println(res.last2(str3));
        System.out.println(res.last2(str4));
        System.out.println(res.last2(str5));
        System.out.println(res.last2(str6));
    }

}
