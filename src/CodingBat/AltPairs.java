package CodingBat;

public class AltPairs {

//    Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
//
//
//    altPairs("kitten") → "kien"
//    altPairs("Chocolate") → "Chole"
//    altPairs("CodingHorror") → "Congrr"

    public String altPairs(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i+=4) {
            res += str.substring(i, Math.min(str.length(), i+2));
        }
        return res;
    }

//    public String altPairs(String str) {
//        String result = "";
//
//        // Run i by 4 to hit 0, 4, 8, ...
//        for (int i=0; i<str.length(); i += 4) {
//            // Append the chars between i and i+2
//            int end = i + 2;
//            if (end > str.length()) {
//                end = str.length();
//            }
//            result = result + str.substring(i, end);
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        String str1 = "kitten";
        String str2 = "Chocolate";
        String str3 = "CodingHorror";
        String str4 = "brdheadsd";
        String str5 = "";
        String str6 = "b";

        AltPairs res = new AltPairs();
        System.out.println(res.altPairs(str1));
        System.out.println(res.altPairs(str2));
        System.out.println(res.altPairs(str3));
        System.out.println(res.altPairs(str4));
        System.out.println(res.altPairs(str5));
        System.out.println(res.altPairs(str6));
    }
}
