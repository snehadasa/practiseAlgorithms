package CodingBat;

public class Close10 {
/*
    Given 2 int values, return whichever value is nearest to the value 10, or return 0 in the event of a tie.
    Note that Math.abs(n) returns the absolute value of a number.


            close10(8, 13) → 8
    close10(13, 8) → 8
    close10(13, 7) → 0
*/

    public int close10(int a, int b) {
        int a1 = Math.abs(10 - a);
        int b1 = Math.abs(10 - b);
        if (a1 == b1) {
            return 0;
        }
        if (a1 < b1) {
            return a;
        } else
            return b;
    }

    public static void main(String[] args) {
        int a1 = 8, b1 = 11;
        int a2 = 9, b2 = 13;
        int a3 = 9, b3 = 11;
        Close10 res = new Close10();
        System.out.println(res.close10(a1, b1));
        System.out.println(res.close10(a2, b2));
        System.out.println(res.close10(a3, b3));
    }
}
