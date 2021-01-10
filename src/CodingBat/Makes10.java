package CodingBat;

public class Makes10 {

//    Given 2 ints, a and b, return true if one if them is 10 or if their sum is 10.
//
//
//    makes10(9, 10) → true
//    makes10(9, 9) → false
//    makes10(1, 9) → true

    public boolean makes10(int a, int b) {
        if (a == 10 || b == 10 || (a + b) == 10) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a1 = 10, b1 = 9;
        int a2 = 1, b2 = 9;
        int a3 = 1, b3 = 1;
        Makes10 res = new Makes10();
        System.out.println(res.makes10(a1, b1));
        System.out.println(res.makes10(a2, b2));
        System.out.println(res.makes10(a3, b3));
    }
}
