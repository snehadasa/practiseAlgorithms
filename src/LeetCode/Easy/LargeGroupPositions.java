package LeetCode.Easy;

import java.util.*;

public class LargeGroupPositions {
//    In a string s of lowercase letters, these letters form consecutive groups of the same character.
//
//    For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
//
//    A group is identified by an interval [start, end], where start and end denote the start and end indices
//    (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].
//
//    A group is considered large if it has 3 or more characters.
//
//    Return the intervals of every large group sorted in increasing order by start index.
//
//
//
//    Example 1:
//
//    Input: s = "abbxxxxzzy"
//    Output: [[3,6]]
//    Explanation: "xxxx" is the only large group with start index 3 and end index 6.
//    Example 2:
//
//    Input: s = "abc"
//    Output: []
//    Explanation: We have groups "a", "b", and "c", none of which are large groups.
//    Example 3:
//
//    Input: s = "abcdddeeeeaabbbcd"
//    Output: [[3,5],[6,9],[12,14]]
//    Explanation: The large groups are "ddd", "eeee", and "bbb".
//    Example 4:
//
//    Input: s = "aba"
//    Output: []
//
//
//    Constraints:
//
//            1 <= s.length <= 1000
//    s contains lower-case English letters only.

    public List<List<Integer>> largeGroupPositions(String s) {
       List<List<Integer>> res = new ArrayList<>();
       int count= 1;

       for (int i = 1; i < s.length(); i++) {
           if (s.charAt(i) == s.charAt(i-1)) {
               count++;
           } else {
               count = 1;
           }

           if (count >= 3 && (i == s.length()-1 || s.charAt(i) != s.charAt(i+1))) {
               List<Integer> entry = new ArrayList<>();
               entry.add(i-count+1);
               entry.add(i);

               res.add(entry);
           }
       }
       return res;
    }


    public List<List<Integer>> largeGroupPositions1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = s.toCharArray();

        for (char c: charArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map.Entry<Character, Integer> maxEntry = null;
        char maxChar = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
                maxChar = entry.getKey();
            }
        }

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == maxChar) {
                start = i;
                list.add(start);
                break;
            }
        }
        for (int i = charArr.length -1; i >= 0; i--) {
            if (charArr[i] == maxChar) {
                end = i;
                list.add(end);
                break;
            }
        }

        result.add(list);
        return result;
    }

    public List<List<Integer>> largeGroupPositions2(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
        LargeGroupPositions res = new LargeGroupPositions();
        System.out.println(res.largeGroupPositions(s));
    }
}
