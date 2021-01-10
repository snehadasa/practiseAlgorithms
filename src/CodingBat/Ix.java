package CodingBat;

public class Ix {

//    Return true if the given string begins with "mix", except the 'm' can be anything, so "pix", "9ix" .. all count.
//
//
//    mixStart("mix snacks") → true
//    mixStart("pix snacks") → true
//    mixStart("piz snacks") → false

    public boolean mixStart(String str) {
        if (str.length() >= 3 && str.substring(1, 3).equals("ix")) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String str1 = "mix wala";
        String str2 = "pix wala";
        Ix ix = new Ix();
        System.out.println(ix.mixStart(str1));
        System.out.println(ix.mixStart(str2));
    }
    // Check if string is too small
    // (so substring() below does not go off the end)
//  if (str.length() < 3) return false;
//
//    // Pull out length 2 string for the "ix" part
//    // (i.e. substring starting at index 1 and stopping just before 3).
//    String two = str.substring(1, 3);
//
//  if (two.equals("ix")) {
//        return true;
//    } else {
//        return false;
//    }
//    // This last part can be shortened to just:
//    // return(two.equals("ix"));
}
