package LeetCode.Easy;

import java.awt.image.ShortLookupTable;

public class CountBinarySubstrings {
//    Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
//    and all the 0's and all the 1's in these substrings are grouped consecutively.
//
//    Substrings that occur multiple times are counted the number of times they occur.
//
//            Example 1:
//    Input: "00110011"
//    Output: 6
//    Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100",
//            "10", "0011", and "01".
//
//    Notice that some of these substrings repeat and are counted the number of times they occur.
//
//    Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
//    Example 2:
//    Input: "10101"
//    Output: 4
//    Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
//            Note:
//
//    s.length will be between 1 and 50,000.
//    s will only consist of "0" or "1" characters.

    public boolean checkConsecutive0And1(char[] s) {
        int count = 0, count0 = 0, count1 = 0;
        for (int i = 0; i < s.length; i++) {
            if (i != s.length-1 && s[i] != s[i+1]) {
                count++;
            }
            if (s[i] == '0') {
                count0++;
            }
            if (s[i] == '1') {
                count1++;
            }
        }
        return count0 == count1 && count == 1;
    }
    public int countBinarySubstrings(String s) {
        int []hops = new int[s.length()];
        int []countOnes = new int[s.length()];
        int count = 0, count0 = 0, count1 = 0;
        int []countZeros = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                count++;
            }
            if (s.charAt(i) == '0') {
                count0++;
            }
            if (s.charAt(i) == '1') {
                count1++;
            }
            hops[i] = count;
            countOnes[i] = count1;
            countZeros[i] = count0;
        }

        count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                int hop = hops[j] - hops[i];
                int ones;
                int zeros;
                if ( i == 0) {
                    ones = countOnes[j];
                    zeros = countZeros[j];
                } else {
                    ones  = countOnes[j] - countOnes[i-1];
                    zeros = countZeros[j] - countZeros[i-1];
                }
                if (hop == 1 && ones == zeros) {
                    count++;
                }
                if (hop > 1) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "000111000";
        CountBinarySubstrings res = new CountBinarySubstrings();
        System.out.println(res.countBinarySubstrings(s));
    }
}
