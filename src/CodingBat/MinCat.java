package CodingBat;

public class MinCat {
//    Given two strings, append them together (known as "concatenation") and
//    return the result. However, if the strings are different lengths, omit chars from
//    the longer string so it is the same length as the shorter string. So "Hello" and "Hi"
//    yield "loHi". The strings may be any length.
//
//
//    minCat("Hello", "Hi") → "loHi"
//    minCat("Hello", "java") → "ellojava"
//    minCat("java", "Hello") → "javaello"

    public String minCat(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        return(a.substring(a.length() - minLength) + b.substring(b.length() - minLength));

        // int al = a.length();
        // int bl = b.length();
        // if (al < bl) {
        //       return a.concat(b.substring(bl - al));
        // } else
        // if (al > bl) {
        //   return a.substring(al - bl).concat(b);
        // }
        // return a.concat(b);
    }

    public static void main(String[] args) {
        String a1 = "hello", b1 = "hi";
        String a2 = "hello", b2 = "java";
        String a3 = "java", b3 = "hello";

        MinCat res = new MinCat();
        System.out.println(res.minCat(a1, b1));
        System.out.println(res.minCat(a2, b2));
        System.out.println(res.minCat(a3, b3));
    }
}
