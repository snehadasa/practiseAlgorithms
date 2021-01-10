package CodingBat.Recursion;

public class NoX {

//    Given a string, compute recursively a new string where all the 'x' chars have been removed.
//
//
//    noX("xaxb") → "ab"
//    noX("abc") → "abc"
//    noX("xx") → ""

    public String noX(String str) {
        if (str.length() < 1) {
            return "";
        }
        if (str.charAt(0) == 'x') {
            return "" + noX(str.substring(1));
        }
        return str.charAt(0) + noX(str.substring(1));
    }

    public static void main(String[] args) {
        NoX res = new NoX();
        System.out.println(res.noX("xabx"));
    }
}
