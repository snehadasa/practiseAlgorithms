package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
//    Write a program that outputs the string representation of numbers from 1 to n.
//
//    But for multiples of three it should output “Fizz” instead of the number and for the multiples of five
//        output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
//
//    Example:
//
//    n = 15,
//
//    Return:
//            [
//            "1",
//            "2",
//            "Fizz",
//            "4",
//            "Buzz",
//            "Fizz",
//            "7",
//            "8",
//            "Fizz",
//            "Buzz",
//            "11",
//            "Fizz",
//            "13",
//            "14",
//            "FizzBuzz"
//            ]

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(i+1);
        }
        for (int i = 0; i < numbers.size(); i++){
            if (numbers.get(i) % 15 == 0) {
                result.add("FizzBuzz");
            } else
                if (numbers.get(i) % 3 == 0) {
                    result.add("Fizz");
                } else
                    if (numbers.get(i) % 5 == 0) {
                        result.add("Buzz");
                    }
                    else
                        result.add(String.valueOf(numbers.get(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        FizzBuzz res = new FizzBuzz();
        int n = 15;
        System.out.println(res.fizzBuzz(n));
    }
}
