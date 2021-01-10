package LeetCode.Easy;

public class BalancedStringSplit {
//    Balanced strings are those who have equal quantity of 'L' and 'R' characters.
//    Given a balanced string s split it in the maximum amount of balanced strings.
//    Return the maximum amount of splitted balanced strings.

//    Example 1:
//    Input: s = "RLRRLLRLRL"
//    Output: 4
//    Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.

//    Example 2:
//    Input: s = "RLLLLRRRLR"
//    Output: 3
//    Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.

//    Example 3:
//    Input: s = "LLLLRRRR"
//    Output: 1
//    Explanation: s can be split into "LLLLRRRR".

//    Example 4:
//    Input: s = "RLRRRLLRLL"
//    Output: 2
//    Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'

//    Constraints:
//            1 <= s.length <= 1000
//    s[i] = 'L' or 'R'

    public int balancedStringSplit(String s) {
        int countR = 0, countL = 0, subStringCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                countR++;
            }
            if (s.charAt(i) == 'L') {
                countL++;
            }
            if (countR == countL) {
                subStringCount++;
                countR = 0;
                countL = 0;
            }

        }
        return subStringCount;
    }

    public static void main(String[] args) {
        String s = "RLRRRLLLRL";
        BalancedStringSplit res = new BalancedStringSplit();
        System.out.println(res.balancedStringSplit(s));
    }
}
