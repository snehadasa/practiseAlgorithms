package NestedLoops;

import java.util.Scanner;

public class EvenSineX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x");
        int x = scanner.nextInt();
        System.out.println("Enter n");
        int n = scanner.nextInt();
        double res = 0;
        long fact = 1;

        for (int i = 1; i < n; ++i) {
            if (n % 2 == 0) {
                res = Math.sin((x ^ n) * n / fact*i);
            }
        }
        System.out.println(res);
    }

}
