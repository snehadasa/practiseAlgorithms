package CodingBat;

public class LastDigit {
//    Given two non-negative int values, return true if they have the same last digit, such as with 27 and 57. Note that the % "mod" operator computes remainders, so 17 % 10 is 7.
//
//
//    lastDigit(7, 17) → true
//    lastDigit(6, 17) → false
//    lastDigit(3, 113) → true

    public boolean lastDigit(int a, int b) {
        int num1 = a%10;
        int num2 = b%10;
        if (num1 == num2)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int a1 = 7, b1 = 17;
        int a2 = 6, b2 = 17;
        int a3 = 3, b3 = 223;
        LastDigit res = new LastDigit();
        System.out.println(res.lastDigit(a1, b1));
        System.out.println(res.lastDigit(a2, b2));
        System.out.println(res.lastDigit(a3, b3));
    }

//    public boolean lastDigit(int a, int b) {
//        // True if the last digits are the same
//        return(a % 10 == b % 10);
//    }

}
