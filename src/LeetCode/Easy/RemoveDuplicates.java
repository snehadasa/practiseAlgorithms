package LeetCode.Easy;

public class RemoveDuplicates {
//    Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
//
//    We repeatedly make duplicate removals on S until we no longer can.
//
//    Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
//
//
//
//            Example 1:
//
//    Input: "abbaca"
//    Output: "ca"
//    Explanation:
//    For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only
//    possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
//
//
//    Note:
//
//            1 <= S.length <= 20000
//    S consists only of English lowercase letters.

    public String removeDuplicates(String S) {
        StringBuilder result = new StringBuilder(S);


        for (int i = 0; i < result.length() - 1; i++) {
            if (result.charAt(i) == result.charAt(i + 1)) {
                result.deleteCharAt(i+1);
                result.deleteCharAt(i);
                i = -1;
            }
        }

        return result.toString();
    }

        public static void main(String[] args) {
        String S = "abbaca";
        String S2 = "aababaab";
        RemoveDuplicates res = new RemoveDuplicates();
        System.out.println(res.removeDuplicates(S));
        System.out.println(res.removeDuplicates(S2));
    }
}
