package CodingBat.Recursion;

public class SumDigits {

//    Given a non-negative int n, return the sum of its digits recursively (no loops). Note that mod (%) by 10 yields the
//    rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
//
//
//    sumDigits(126) → 9
//    sumDigits(49) → 13
//    sumDigits(12) → 3

    public int sumDigits(int n) {
        int rem = n % 10;
        int digits = (n - rem) / 10;

        if (n < 10) {
            return n;
        }
        return rem + sumDigits(digits);
    }

    public static void main(String[] args) {
        SumDigits res = new SumDigits();
        System.out.println(res.sumDigits(67));
        System.out.println(res.sumDigits(675));
    }
}
