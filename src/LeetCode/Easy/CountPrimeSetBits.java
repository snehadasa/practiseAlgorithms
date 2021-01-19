package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CountPrimeSetBits {
//    Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of
//    set bits in their binary representation.
//
//            (Recall that the number of set bits an integer has is the number of 1s present when written in binary.
//            For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
//
//    Example 1:
//
//    Input: L = 6, R = 10
//    Output: 4
//    Explanation:
//            6 -> 110 (2 set bits, 2 is prime)
//            7 -> 111 (3 set bits, 3 is prime)
//            9 -> 1001 (2 set bits , 2 is prime)
//            10->1010 (2 set bits , 2 is prime)
//    Example 2:
//
//    Input: L = 10, R = 15
//    Output: 5
//    Explanation:
//            10 -> 1010 (2 set bits, 2 is prime)
//            11 -> 1011 (3 set bits, 3 is prime)
//            12 -> 1100 (2 set bits, 2 is prime)
//            13 -> 1101 (3 set bits, 3 is prime)
//            14 -> 1110 (3 set bits, 3 is prime)
//            15 -> 1111 (4 set bits, 4 is not prime)
//    Note:
//
//    L, R will be integers L <= R in the range [1, 10^6].
//    R - L will be at most 10000.

    public int binaryToDecimal(String num) {
        int base = 1;
        int decValue = 0;

        for (int i = num.length()-1; i >= 0; i--) {
            if (num.charAt(i) == '1') {
                decValue += base;
            }
            base *= 2;
        }
        return decValue;
    }

    boolean primeNumber(int number) {
        if (primeNumbers.contains(number)) {
            return  true;
        }
        if (nonPrimeNumbers.contains(number)) {
            return false;
        }

        boolean flag = number != 1;

        //int number = Integer.parseInt(num);
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }

        if (flag) {
            this.primeNumbers.add(number);
        } else {
            this.nonPrimeNumbers.add(number);
        }
        return flag;
    }
    int checkOnes(String one) {
        int count = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public int countPrimeSetBits(int L, int R) {
        List<Integer> nums = new ArrayList<>();

        for (int i = L; i <= R; i++) {
            nums.add(i);
        }
        String []arr = new String[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = Integer.toString(nums.get(i), 2);
        }

        int count = 0;
        int[] countArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            countArr[i] = checkOnes(arr[i]);
        }
        for (int i = 0; i < countArr.length; i++) {
            if (primeNumber(countArr[i])) {
//                System.out.println(countArr[i]);
                count++;
            }
        }
        return count;
    }

    private HashSet<Integer> primeNumbers = new HashSet<>();
    private HashSet<Integer> nonPrimeNumbers = new HashSet<>();

    public static void main(String[] args) {
        int L = 6, R = 10;
        CountPrimeSetBits res = new CountPrimeSetBits();
        //System.out.println(res.binaryToDecimal("10101"));
        //System.out.println(Arrays.toString(res.countPrimeSetBits(L, R)));
        System.out.println(res.countPrimeSetBits(244, 269));
        //System.out.println(res.primeNumber(2));
    }
}
