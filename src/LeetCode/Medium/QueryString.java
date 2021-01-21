package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class QueryString {
//    Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, return true if and
//    only if for every integer X from 1 to N, the binary representation of X is a substring of S.
//
//            Example 1:
//
//    Input: S = "0110", N = 3
//    Output: true
//    Example 2:
//
//    Input: S = "0110", N = 4
//    Output: false
//
//
//    Note:
//
//            1 <= S.length <= 1000
//            1 <= N <= 10^9

    public int binaryToString(String n) {
        int base = 1;
        int decValue = 0;

        for (int i = n.length()-1; i >= 0; i--){
            if (n.charAt(i) == '1') {
                decValue += base;
            }
            base *= 2;
        }
        return decValue;
    }

    public boolean queryString(String S, int N) {
        List<Boolean> booleanArr = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!S.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String S1 = "0110", S2 = "110101011011000011011111000000";
        int N1 = 3, N2 = 4, N3 = 15;
        QueryString res = new QueryString();
        System.out.println(res.queryString(S1, N1));
        System.out.println(res.queryString(S1, N2));
        System.out.println(res.queryString(S2, N3));
    }
}
