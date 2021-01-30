package LeetCode.Easy;

public class BackspaceCompare {
//    Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
//
//    Note that after backspacing an empty text, the text will continue empty.
//
//            Example 1:
//
//    Input: S = "ab#c", T = "ad#c"
//    Output: true
//    Explanation: Both S and T become "ac".
//    Example 2:
//
//    Input: S = "ab##", T = "c#d#"
//    Output: true
//    Explanation: Both S and T become "".
//    Example 3:
//
//    Input: S = "a##c", T = "#a#c"
//    Output: true
//    Explanation: Both S and T become "c".
//    Example 4:
//
//    Input: S = "a#c", T = "b"
//    Output: false
//    Explanation: S becomes "c" while T becomes "b".
//    Note:
//
//            1 <= S.length <= 200
//            1 <= T.length <= 200
//    S and T only contain lowercase letters and '#' characters.
//    Follow up:
//
//    Can you solve it in O(N) time and O(1) space?

    public String backSpaceChar(String str) {
        StringBuilder s = new StringBuilder(str);
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '#') {
                s.deleteCharAt(i);
                i--;
            } else
            if (s.charAt(i) == '#') {
                s.deleteCharAt(i);
                s.deleteCharAt(i-1);
                i = -1;
            }
        }
        return s.toString();
    }
    public boolean backspaceCompare(String S, String T) {
        String s = backSpaceChar1(S);
        String t = backSpaceChar1(T);

        return (s.equals(t) ? true : false);
    }

    public String backSpaceChar1(String str) {
        StringBuilder s = new StringBuilder();
        for(char current: str.toCharArray()){
            if (current == '#') {
                if (s.length() > 0) {
                    s.deleteCharAt(s.length() - 1);
                }
            } else {
                s.append(current);
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String s = "y#fo##f", t = "y#f#o##f";
        String s1 = "a#c", t1 = "b";

        BackspaceCompare res = new BackspaceCompare();
//        System.out.println(res.backspaceCompare(s, t));
        System.out.println(res.backspaceCompare(s1, t1));
    }
}
