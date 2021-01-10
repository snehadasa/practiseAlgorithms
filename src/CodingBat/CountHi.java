package CodingBat;

public class CountHi {

//    Return the number of times that the string "hi" appears anywhere in the given string.
//
//
//    countHi("abc hi ho") → 1
//    countHi("ABChi hi") → 2
//    countHi("hihi") → 2

    public int countHi(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'h' && str.charAt(i+1) == 'i') {
                count++;
            }
        }
        return count;
    }

//    public int countHi(String str) {
//        int count = 0;
//        // Loop to length-1 so we can access index i and i+1 in the loop.
//        for (int i = 0; i < (str.length() - 1); i++) {
//            if (str.substring(i, i+2).equals("hi")) count++;
//        }
//        return count;
//    }

    public static void main(String[] args) {
        String str1 = "abc hi ho";
        String str2 = "ABChi hi";
        String str3 = "hihi";


        CountHi res = new CountHi();
        System.out.println(res.countHi(str1));
        System.out.println(res.countHi(str2));
        System.out.println(res.countHi(str3));
    }
}
