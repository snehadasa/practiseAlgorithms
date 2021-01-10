package CodingBat;

public class WithoutX {

    //    Given a string, if the first or last chars are 'x', return the string without those 'x' chars, and otherwise return the string unchanged.
//
//
//            withoutX("xHix") → "Hi"
//    withoutX("xHi") → "Hi"
//    withoutX("Hxix") → "Hxi"
    public String withoutX(String str) {
        if (str.length() <= 1) {
            return "";
        }
        if (str.startsWith("x") && !(str.endsWith("x"))) {
            return str.substring(1);
        } else if (!(str.startsWith("x")) && str.endsWith("x")) {
            return str.substring(0, str.length() - 1);
        } else if (str.startsWith("x") && str.endsWith("x")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

//    public String withoutX(String str) {
//        if (str.length() > 0 && str.charAt(0) == 'x') {
//            str = str.substring(1);
//        }
//
//        if (str.length() > 0 && str.charAt(str.length()-1) == 'x') {
//            str = str.substring(0, str.length()-1);
//        }
//
//        return str;
//
//        // Solution  notes: check for the 'x' in both spots. If found, use substring()
//        // to grab the part without the 'x'. Check that the length is greater than 0
//        // each time -- the need for the second length check is tricky to see.
//        // One could .substring() instead of .charAt() to look into the string.
//    }




    public static void main(String[] args) {
        String str1 = "xhix";
        String str2 = "xhi";
        String str3 = "hxix";
        String str4 = "xxhi";
        String str5 = "";
        String str6 = "x";

        WithoutX res = new WithoutX();
        System.out.println(res.withoutX(str1));
        System.out.println(res.withoutX(str2));
        System.out.println(res.withoutX(str3));
        System.out.println(res.withoutX(str4));
        System.out.println(res.withoutX(str5));
        System.out.println(res.withoutX(str6));
    }
}
