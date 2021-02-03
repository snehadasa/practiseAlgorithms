package LeetCode.Easy;

import java.util.*;

public class FirstUniqueChar {
//    Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
//
//    Examples:
//
//    s = "leetcode"
//            return 0.
//
//    s = "loveleetcode"
//            return 2.
//
//
//    Note: You may assume the string contains only lowercase English letters.

    public int firstUniqChar1(String s) {
        Map<Character, Integer> mapCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapCount.containsKey(s.charAt(i))) {
                int value = mapCount.get(s.charAt(i));
                mapCount.put(s.charAt(i), 1 + value);
            } else
                mapCount.put(s.charAt(i), 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (mapCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar(String s) {
        int[] count = new int[256];
        char[] chars = s.toCharArray();

        for (char c : chars) {
            count[c]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "loveleetcode";
        String s2 = "leetcode";
        FirstUniqueChar res = new FirstUniqueChar();
        System.out.println(res.firstUniqChar(s1));
        System.out.println(res.firstUniqChar(s2));
    }
}
