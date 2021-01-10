package CodingBat;

public class CountCode {

//    Return the number of times that the string "code" appears anywhere in the given string,
//    except we'll accept any letter for the 'd', so "cope" and "cooe" count.
//
//
//    countCode("aaacodebbb") → 1
//    countCode("codexxcode") → 2
//    countCode("cozexxcope") → 2

    public int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (i <= str.length() - 4 && str.charAt(i) == 'c' && str.charAt(i+1) == 'o' && str.charAt(i+3) == 'e') {
                count++;
            }
        }
        return count;
    }

//    public int countCode(String str) {
//        int count = 0;
//
//        for(int i = 0; i < str.length() - 3; i++) {
//            if(str.substring(i, i + 2).equals("co") && str.charAt(i + 3) == 'e')
//                count++;
//        }
//
//        return count;
//    }

    public static void main(String[] args) {
        String str1 = "aaacodebbb";
        String str2 = "codexxcodei";
        String str3 = "cozexxcope";


        CountCode res = new CountCode();
        System.out.println(res.countCode(str1));
        System.out.println(res.countCode(str2));
        System.out.println(res.countCode(str3));
    }

}
