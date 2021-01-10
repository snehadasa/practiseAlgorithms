package NestedLoops;

public class FibonacciNumbers {
    public static void main(String[] args) {
        long fact = 1;
        int n = 10;
        for (int i = 1; i < n; ++i) {
            fact *= i;
        }
        System.out.println(fact);
    }
}
