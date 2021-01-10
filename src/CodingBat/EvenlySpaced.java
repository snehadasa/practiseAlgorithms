package CodingBat;

public class EvenlySpaced {

//    Given three ints, a b c, one of them is small, one is medium and one is large. Return true if the three values
//    are evenly spaced, so the difference between small and medium is the same as the difference between medium and large.
//
//
//    evenlySpaced(2, 4, 6) → true
//    evenlySpaced(4, 6, 2) → true
//    evenlySpaced(4, 6, 3) → false

    public boolean evenlySpaced(int a, int b, int c) {
        if (a == b && b == c) {
            return true;
        }
        if (a != b && b != c && a != c) {
            if (diff(a, b) == diff(b, c)) {
                return true;
            } else
            if (diff(a, c) == diff(b, c)) {
                return true;
            } else
            if (diff(a, b) == diff(a, c)) {
                return true;
            }
        }
        return false;
    }

    public int diff(int num1, int num2) {
        int different = Math.abs(num1 - num2);
        return different;
    }

    public static void main(String[] args) {
        EvenlySpaced res = new EvenlySpaced();
        System.out.println(res.evenlySpaced(2, 2, 2));
        System.out.println(res.evenlySpaced(2, 3, 4));
        System.out.println(res.evenlySpaced(11, 6, 4));
    }
}
