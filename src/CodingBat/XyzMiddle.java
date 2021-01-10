package CodingBat;

public class XyzMiddle {

//    Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars
//    to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
//
//
//    xyzMiddle("AAxyzBB") → true
//    xyzMiddle("AxyzBB") → true
//    xyzMiddle("AxyzBBB") → false

    public boolean xyzMiddle(String str) {
        //int midO = Math.abs((str.length() / 2) - 1);
//        int midE = (str.length() / 2);
//
//        for (int i = 0; i < str.length() - 1; i++) {
//            if (str.length() % 2 == 0) {
//                if (str.charAt(midE - 1) == 'x' && str.charAt(midE) == 'y' && str.charAt(midE + 1) == 'z') {
//                    return true;
//                }
//            }
//            else if (str.length() % 2 == 1) {
//                if (str.charAt(midE - 1) == 'x' && str.charAt(midE) == 'y' && str.charAt(midE + 1) == 'z') {
//                    return true;
//                }
//            }
//        }
//        return false;
        if (str.length() < 3) {
            return false;
        }
        int actualIndex = str.indexOf("xyz", (str.length() / 2) - 3);
        int numbersOnLeft = actualIndex;
        int numbersOnRight = str.length() - actualIndex - 3;
        return Math.abs(numbersOnRight - numbersOnLeft) <= 1;
    }

    public static void main(String[] args) {
        String str1 = "AAxyzBB";
        String str2 = "AxyzBB";
        String str3 = "AxyzBBB";

        XyzMiddle res = new XyzMiddle();
        System.out.println(res.xyzMiddle(str1));
        System.out.println(res.xyzMiddle(str2));
        System.out.println(res.xyzMiddle(str3));
    }
}
