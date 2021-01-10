package NestedLoops;

import java.util.Scanner;

public class SineX {

//    Write a program to compute sinx for given x. The user should supply x and a positive integer n. We compute the
//    sine of x using the series and the computation should use all terms in the series up through the term involving xn
//
//    sin x = x - x3/3! + x5/5! - x7/7! + x9/9! .......

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x");
        int x = scanner.nextInt();
        System.out.println("Enter n");
        int n = scanner.nextInt();
        double res = 0;
        long fact = 1;
        for (int i = 1; i < n; ++i) {
            if (n % 2 == 1) {
                res = Math.sin(x - ((x ^ n) * n / fact * i));
            }
        }

        System.out.println(res);
    }
}
