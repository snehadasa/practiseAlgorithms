package CodingBat;

public class TwoChar {

//    Given a string and an index, return a string length 2 starting at the given index.
//    If the index is too big or too small to define a string length 2, use the first 2 chars.
//    The string length will be at least 2.
//
//
//    twoChar("java", 0) → "ja"
//    twoChar("java", 2) → "va"
//    twoChar("java", 3) → "ja"

    public String twoChar(String str, int index) {
        if (index > 0 && str.length() > 2 && (index < str.length() - 1)) {
            return str.substring(index, index+2);
        }
        return str.substring(0, 2);
    }

    public static void main(String[] args) {
        String s1 = "java", s2 = "java", s3 = "java";
        int i1 = 0, i2 = 2, i3 = 3;
        TwoChar res = new TwoChar();
        System.out.println(res.twoChar(s1, i1));
        System.out.println(res.twoChar(s2, i2));
        System.out.println(res.twoChar(s3, i3));
    }
}
