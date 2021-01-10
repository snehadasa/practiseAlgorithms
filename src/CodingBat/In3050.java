package CodingBat;

public class In3050 {

    //    Given 2 int values, return true if they are both in the range 30..40 inclusive, or they are both in the range 40..50 inclusive.
//
//
//            in3050(30, 31) → true
//    in3050(30, 41) → false
//    in3050(40, 50) → true
    public boolean in3050(int a, int b) {
        if ((a >= 30 && a <= 40) && (b >= 30 && b <= 40) ||
                (a >= 40 && a <= 50) && (b >= 40 && b <= 50)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a1 = 38, b1 = 31;
        int a2 = 29, b2 = 43;
        int a3 = 49, b3 = 41;
        In3050 res = new In3050();
        System.out.println(res.in3050(a1, b1));
        System.out.println(res.in3050(a2, b2));
        System.out.println(res.in3050(a3, b3));
    }
}
