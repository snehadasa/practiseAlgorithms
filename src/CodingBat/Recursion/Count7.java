package CodingBat.Recursion;

public class Count7 {

//    Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2.
//            (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10
//    removes the rightmost digit (126 / 10 is 12).
//
//
//    count7(717) → 2
//    count7(7) → 1
//    count7(123) → 0

    public int count7(int n) {
        int rem = n % 10;
        int removelast = n / 10;
        int count = 0;

        if (rem == 7) {
            count++;
        }

        if (removelast == 0) {
            return count;
        }

        return count + count7(removelast);
    }

    public static void main(String[] args) {
        Count7 res = new Count7();
        System.out.println(res.count7(77717157));
    }
}
