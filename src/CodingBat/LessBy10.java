package CodingBat;

public class LessBy10 {

//    Given three ints, a b c, return true if one of them is 10 or more less than one of the others.
//
//    lessBy10(1, 7, 11) → true
//    lessBy10(1, 7, 10) → false
//    lessBy10(11, 1, 7) → true

    public boolean lessBy10(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int diff = max-min;
        if (diff >= 10) {
            return true;
        }
        return false;
    }

    public boolean lessBy10A(int a, int b, int c) {
        return (Math.abs(a - b) >= 10 ||
                Math.abs(b - c) >= 10 ||
                Math.abs(a - c) >= 10);

        // Solution notes: it's a bit surprising that this can be so short.
        // We simplify by using Math.abs() to take the absolute value --
        // say with the ab pair, one is smaller and one is bigger, but we don't
        // care which is which, since we are just looking for a difference
        // of 10 or more.
    }

    public static void main(String[] args) {
        LessBy10 res = new LessBy10();
        System.out.println(res.lessBy10(3, 3, 30));
    }
}
