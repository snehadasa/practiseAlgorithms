package LeetCode.Easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NumPrimeArrangements {
//    Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
//
//(Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two
//    positive integers both smaller than it.)
//
//    Since the answer may be large, return the answer modulo 10^9 + 7.
//
//
//
//    Example 1:
//
//    Input: n = 5
//    Output: 12
//    Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
//    Example 2:
//
//    Input: n = 100
//    Output: 682289015
//
//
//    Constraints:
//
//            1 <= n <= 100

   int highestPrime = (int) Math.pow(10, 9) + 7;
   public int countPrimeNumberInArr(int n) {
       int count = 0;
       boolean[] isPrime = new boolean[n + 1];
       for (int i = 0; i <= n; i++) {
           isPrime[i] = true;
       }

       for (int i = 2; i*i <= n; i++) {
           if (isPrime[i] == true) {
               for (int j = i*i; j <= n; j+=i) {
                   isPrime[j] = false;
               }
           }
       }

       for (int i = 2; i <= n; i++) {
           if (isPrime[i] == true) {
               count++;
           }
       }
       return count;
   }

   public int numPrimeArrangements(int n) {
       int primeCount = countPrimeNumberInArr(n);
       long fact = 1;

       for (int i = 1; i <= primeCount; i++) {
           fact = (fact*i) % highestPrime;
       }

       for (int i = 1; i <= (n-primeCount); i++) {
           fact = (fact*i) % highestPrime;
       }

       return (int)fact;
   }
    public static void main(String[] args) {
        int n = 5;
        NumPrimeArrangements res = new NumPrimeArrangements();
        System.out.println(res.numPrimeArrangements(n));
        //System.out.println(res.countIsPrime(n));
    }
}
