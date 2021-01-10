package CodingBat;

public class EndOther {

//    Given two strings, return true if either of the strings appears at the very end of the other string,
//    ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
//    Note: str.toLowerCase() returns the lowercase version of a string.
//
//
//            endOther("Hiabc", "abc") → true
//    endOther("AbC", "HiaBc") → true
//    endOther("abc", "abXabc") → true

    public boolean endOther(String a, String b) {
        String anew = a.toLowerCase();
        String bnew = b.toLowerCase();
        if (anew.length() == bnew.length() && anew.equals(bnew)) {
            return true;
        }
        if (anew.length() > bnew.length()) {
            if (anew.substring(anew.length() - bnew.length()).equals(bnew)) {
                return true;
            }
        } else if (bnew.length() > anew.length()) {
            if (bnew.substring(bnew.length() - anew.length()).equals(anew)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a1 = "Hiabc", b1 = "abc";
        String a2 = "AbC", b2 = "HiaBc";
        String a3 = "abc", b3 = "abXabc";

        EndOther res = new EndOther();
        System.out.println(res.endOther(a1, b1));
        System.out.println(res.endOther(a2, b2));
        System.out.println(res.endOther(a3, b3));
    }
}
