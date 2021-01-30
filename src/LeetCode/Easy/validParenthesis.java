package LeetCode.Easy;

import datastructures.Stack;

public class validParenthesis {
//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//
//
//            Example 1:
//
//    Input: s = "()"
//    Output: true
//    Example 2:
//
//    Input: s = "()[]{}"
//    Output: true
//    Example 3:
//
//    Input: s = "(]"
//    Output: false
//    Example 4:
//
//    Input: s = "([)]"
//    Output: false
//    Example 5:
//
//    Input: s = "{[]}"
//    Output: true
//
//
//    Constraints:
//
//            1 <= s.length <= 104
//    s consists of parentheses only '()[]{}'.

    public boolean isValid(String s) {
        char[] parenthesis = s.toCharArray();
        Stack<Character> braces = new Stack<>();

        for (char character : parenthesis) {
            if (character == '(' || character == '{' || character == '[') {
                braces.push(character);
            }

            if (character == ')' || character == '}' || character == ']') {
                if (braces.isEmpty()) {
                    return false;
                }

                Character remove = braces.pop();
                char toCompare = '1';

                switch (remove) {
                    case '(':
                        toCompare = ')';
                        break;
                    case '{':
                        toCompare = '}';
                        break;
                    case '[':
                        toCompare = ']';
                        break;
                    default:
                        break;
                }

                if (toCompare != character) {
                    return false;
                }
            }
        }
        return braces.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()[]{}";
        validParenthesis res = new validParenthesis();
        System.out.println(res.isValid(str));
    }
}
