package LeetCode.Medium;

public class PrimePalindrome {
//    Find the smallest prime palindrome greater than or equal to N.
//
//    Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.
//
//    For example, 2,3,5,7,11 and 13 are primes.
//
//    Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.
//
//    For example, 12321 is a palindrome.
//
//
//
//            Example 1:
//
//    Input: 6
//    Output: 7
//    Example 2:
//
//    Input: 8
//    Output: 11
//    Example 3:
//
//    Input: 13
//    Output: 101
//
//
//    Note:
//
//            1 <= N <= 10^8
//    The answer is guaranteed to exist and be less than 2 * 10^8.

    public boolean primeNumber(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { //condition for prime(if number is divided by any num other than 1 and itself, then its prime).
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(int n) {
        //String nRev =
        int rem = 0;
        int rev = 0;
        int temp = n;
        while (n != 0) {
            rem = n%10;
            rev = (rev*10)+rem;
            n /= 10;
        }
        if (temp == rev) {
            return true;
        }
        return false;
    }

    public int primePalindrome(int N) {
        int res = 0;
        if (N == 1 || N == 2) {
            return 2;
        }

        for (int i = N%2 == 0 ? N+1 : N;true; i += 2) {
            if (primeNumber(i) && isPalindrome(i)) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 13;
        PrimePalindrome res = new PrimePalindrome();
        System.out.println(res.primePalindrome(n));
    }
}
