package CodingBat;

import java.util.Arrays;

public class FizzBuzz {

//    This is slightly more difficult version of the famous FizzBuzz problem which is sometimes
//    given as a first problem for job interviews. (See also: FizzBuzz Code.) Consider the series of numbers
//    beginning at start and running up to but not including end, so for example start=1 and end=5 gives the
//        series 1, 2, 3, 4. Return a new String[] array containing the string form of these numbers, except
//    for multiples of 3, use "Fizz" instead of the number, for multiples of 5 use "Buzz", and for multiples
//    of both 3 and 5 use "FizzBuzz". In Java, String.valueOf(xxx) will make the String form of an int or other
//    type. This version is a little more complicated than the usual version since you have to allocate and index
//    into an array instead of just printing, and we vary the start/end instead of just always doing 1..100.
//
//
//    fizzBuzz(1, 6) → ["1", "2", "Fizz", "4", "Buzz"]
//    fizzBuzz(1, 8) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7"]
//    fizzBuzz(1, 11) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"]

    public String[] fizzBuzz(int start, int end) {
        int[] arr1 = new int[end - start];
        for (int i = 0; i < (end - start); i++) {
            arr1[i] = start + i;
        }
        String[] newA = new String[end - start];
        for (int i = 0; i < (end - start); i++) {
            if (arr1[i] % 15 == 0) {
                newA[i] = "FizzBuzz";
            } else
            if (arr1[i] % 3 == 0)
                newA[i] = "Fizz";
            else if (arr1[i] % 5 == 0)
                newA[i] = "Buzz";
            else newA[i] = String.valueOf(arr1[i]);
        }
        return newA;
    }

    public static void main(String[] args) {
        int start1 = 1, end1 = 6;
        int start2 = 1, end2 = 8;
        int start3 = 1, end3 = 11;

        FizzBuzz res = new FizzBuzz();
        System.out.println(Arrays.toString(res.fizzBuzz(start1, end1)));
        System.out.println(Arrays.toString(res.fizzBuzz(start2, end2)));
        System.out.println(Arrays.toString(res.fizzBuzz(start3, end3)));
    }
}
