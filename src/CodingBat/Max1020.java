package CodingBat;

public class Max1020 {

//    Given 2 positive int values, return the larger value that is in the range 10..20 inclusive, or return 0 if neither is in that range.
//
//
//            max1020(11, 19) → 19
//    max1020(19, 11) → 19
//    max1020(11, 9) → 11

    public int max1020(int a, int b) {
        if ((a >= 10 && a <= 20) && !(b >= 10 && b <= 20)) {
            return a;
        } else
        if (!(a >= 10 && a <= 20) && (b >= 10 && b <= 20)) {
            return b;
        } else
        if ((a >= 10 && a <= 20) && (b >= 10 && b <= 20)) {
            if (a > b) {
                return a;
            }
            return b;
        }
        return 0;
    }

//    public int max1020(int a, int b) {
//        // First make it so the bigger value is in a
//        if (b > a) {
//            int temp = a;
//            a = b;
//            b = temp;
//        }
//
//        // Knowing a is bigger, just check a first
//        if (a >= 10 && a <= 20) return a;
//        if (b >= 10 && b <= 20) return b;
//        return 0;
//    }

    public static void main(String[] args) {
        int a1 = 18, b1 = 11;
        int a2 = 9, b2 = 13;
        int a3 = 19, b3 = 1;
        Max1020 res = new Max1020();
        System.out.println(res.max1020(a1, b1));
        System.out.println(res.max1020(a2, b2));
        System.out.println(res.max1020(a3, b3));
    }
}
