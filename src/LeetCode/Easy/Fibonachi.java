package LeetCode.Easy;

public class Fibonachi {
//    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number
//    is the sum of the two preceding ones, starting from 0 and 1. That is,
//
//    F(0) = 0, F(1) = 1
//    F(n) = F(n - 1) + F(n - 2), for n > 1.
//    Given n, calculate F(n).
//
//
//
//    Example 1:
//
//    Input: n = 2
//    Output: 1
//    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//    Example 2:
//
//    Input: n = 3
//    Output: 2
//    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//    Example 3:
//
//    Input: n = 4
//    Output: 3
//    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
//
//
//    Constraints:
//
//            0 <= n <= 30

    //recursion
    public int fib1(int n) {
        if (n <= 1) {
            return n;
        }

        return fib1(n - 1) + fib1(n - 2);
    }

    public int fib2(int n) {
      if (n == 0) return 0;
      if (n == 1) return 1;

      int sum = 0, fibN1 = 1, fibN2 = 0;

      for (int i = 2; i <= n; i++) {
          sum = fibN1 + fibN2;
          fibN2 = fibN1;
          fibN1 = sum;
      }
      return sum;
    }

    public int fib(int n) {
        int[] res = new int[n+1];
        int result = 0;
        res[0] = 0;
        res[1] = 1;

        for (int i = 2; i < n+1; i++) {
            res[i] = res[i - 1] + res[i-2];
        }

        return res[n];
    }

    public int fib3(int n) {
        int[] res = new int[n+1];
        int result = 0;
        if (res[n] != 0) {
            return res[n];
        }
        if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = fib(n-1) + fib(n - 2);
        }
        res[n] = result;
        return result;
    }

        public static void main(String[] args) {
        int n = 5;
        Fibonachi res = new Fibonachi();
        System.out.println(res.fib(n));
    }
}
