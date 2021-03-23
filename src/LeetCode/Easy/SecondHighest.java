package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondHighest {
//    Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
//
//    An alphanumeric string is a string consisting of lowercase English letters and digits.
//
//
//
//            Example 1:
//
//    Input: s = "dfa12321afd"
//    Output: 2
//    Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
//    Example 2:
//
//    Input: s = "abc1111"
//    Output: -1
//    Explanation: The digits that appear in s are [1]. There is no second largest digit.
//
//
//    Constraints:
//
//            1 <= s.length <= 500
//    s consists of only lowercase English letters and/or digits.

    public String removeDuplicates(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String newStr = new String(arr);
        StringBuilder result = new StringBuilder(newStr);
        for (int i = 0; i < result.length() - 1; i++) {
            if (result.charAt(i) == result.charAt(i + 1)) {
                result.deleteCharAt(i+1);
                i = -1;
            }
        }
        return result.toString();
    }
    public int secondHighest(String s) {
        List<Integer> list = new ArrayList<>();

        String newStr = removeDuplicates(s);
        for (int i = 0; i < newStr.length(); i++) {
           if (Character.isDigit(newStr.charAt(i))) {
               list.add(newStr.charAt(i) - '0');
           }
        }
        if (list.size() <= 1) {
            return -1;
        }
        Collections.sort(list, Collections.reverseOrder());
        return list.get(1);
    }

    public int secondHighest1(String s) {
        List<Integer> list = new ArrayList();
        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                list.add(Character.getNumericValue(s.charAt(i)));
            }
        }
        Collections.sort(list);
        for(int i = list.size() - 1; i >= 0; i--)
        {
            if(list.get(list.size() - 1) > list.get(i))
            {
                return list.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "dfa12321afd";
        SecondHighest res = new SecondHighest();
        System.out.println(res.secondHighest(s));
       // System.out.println(res.removeDuplicates(s));
    }
}
