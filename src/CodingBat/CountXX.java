package CodingBat;

public class CountXX {

//    Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
//
//
//    countXX("abcxx") → 1
//    countXX("xxx") → 2
//    countXX("xxxx") → 3

    int countXX(String str) {
        int count = 0;
        char[] chars = str.toCharArray();

        for (int i = 0, n = chars.length - 1; i < n; i++) {
            if (chars[i] == 'x' && chars[i+1] == 'x') {
                count += 1;
            }
        }

        return count;
    }

//    int countXX(String str) {
//        int count = 0;
//        for (int i = 0; i < str.length()-1; i++) {
//            if (str.substring(i, i+2).equals("xx")) count++;
//        }
//        return count;
//    }

    public static void main(String[] args) {
        String str1 = "abcxx";
        String str2 = "xxx";
        String str3 = "xxxx";
        String str4 = "";
        String str5 = "xabcxx";
        String str6 = "abxxxcd";

        CountXX res = new CountXX();
        System.out.println(res.countXX(str1));
        System.out.println(res.countXX(str2));
        System.out.println(res.countXX(str3));
        System.out.println(res.countXX(str4));
        System.out.println(res.countXX(str5));
        System.out.println(res.countXX(str6));
    }
}
