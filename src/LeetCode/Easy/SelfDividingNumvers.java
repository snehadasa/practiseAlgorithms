package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumvers {
//    A self-dividing number is a number that is divisible by every digit it contains.
//
//    For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
//
//    Also, a self-dividing number is not allowed to contain the digit zero.
//
//    Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
//
//            Example 1:
//    Input:
//    left = 1, right = 22
//    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
//    Note:
//
//    The boundaries of each input argument are 1 <= left <= right <= 10000.

    public boolean individualDividingNumber(int n) {
        int temp = n;
        int rem = 0;
        while (temp != 0) {
            rem = temp % 10;
            if (rem == 0 || n%rem != 0) {
                return false;
            }
            temp /= 10;
        }

        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> newList = new ArrayList<>();
        List<Integer> individual = new ArrayList<>();
        int num = 0;
        for (int i = left; i <= right; i++) {
            newList.add(i);
        }
        for (int i = 0; i < newList.size(); i++) {
            num = newList.get(i);
            if (individualDividingNumber(num)) {
                individual.add(num);
            }
            num /= 10;
        }
        return individual;
    }

    public static void main(String[] args) {
        int left = 20, right = 22;
        int left1 = 1, right1 = 22;
        int n = 128;
        SelfDividingNumvers res = new SelfDividingNumvers();
        System.out.println(res.selfDividingNumbers(left, right));
        //System.out.println(res.individualDividingNumber(n));
    }
}
