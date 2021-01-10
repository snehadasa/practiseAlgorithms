package CodingBat;

public class SameStarChar {

//    Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star,
//    they are the same.
//
//
//            sameStarChar("xy*yzz") → true
//    sameStarChar("xy*zzz") → false
//    sameStarChar("*xa*az") → true

    public boolean sameStarChar(String str) {
        if (str.length() < 3 || !str.contains("*")) {
            return true;
        }
        for (int i = 1; i < str.length() - 1; i++) {

            if (str.charAt(i) == '*') {
                if (str.charAt(i - 1) != str.charAt(i + 1)) {
                    return false;
                }
            }
        }


        return true;

        //for (int i = 0; i < str.length() - 1; i++) {
//
//            if (str.charAt(i) == '*') {
//               count++;
//            }
//        }
//        if (count >= 2) {
//            for (int i = 1; i < str.length() - 1; i++) {
//                if (str.charAt(i) == '*' && str.charAt(i-1) && str.charAt(i+1)) {
//                    firststarindex = i;
//                    break;
//                }
//            }
//            for (int i = firststarindex; i < str.length() - 1; i++) {
//                if (str.charAt(i) == '*') {
//                    secondstarindex = i;
//                    break;
//                }
//            }
//            if ((str.charAt(firststarindex - 1) == str.charAt(firststarindex + 1)) ||
//                    (str.substring(secondstarindex - 1) == str.substring(secondstarindex + 1))) {
//                return true;
//            }
//            return false;
//        }
    }

    public static void main(String[] args) {
        String str1 = "*xa*a*b";
        String str2 = "12*2*3*";
        String str3 = "XY*YYYY*Z*";

        SameStarChar res = new SameStarChar();
        System.out.println(res.sameStarChar(str1));
        System.out.println(res.sameStarChar(str2));
        System.out.println(res.sameStarChar(str3));
    }
}
