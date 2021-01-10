package CodingBat.Testing;

import CodingBat.FizzBuzz;

public class FizzBuzz2 {
    public String fizzString2(int n) {
        if (n%3 == 0 && n%5 == 0) {
            return "FizzBuzz!";
        } else
        if (n%3 == 0) {
            return "Fizz!";
        } else
        if (n%5 == 0) {
            return "Buzz!";
        }
        return String.valueOf(n) + "!";
    }

    public static void main(String[] args) {
        FizzBuzz2 res = new FizzBuzz2();
        System.out.println(res.fizzString2(2));
    }
}
