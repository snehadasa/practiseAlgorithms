package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseOnlyLetters {
//    Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
//    and all letters reverse their positions.
//
//            Example 1:
//
//    Input: "ab-cd"
//    Output: "dc-ba"
//    Example 2:
//
//    Input: "a-bC-dEf-ghIj"
//    Output: "j-Ih-gfE-dCba"
//    Example 3:
//
//    Input: "Test1ng-Leet=code-Q!"
//    Output: "Qedo1ct-eeLg=ntse-T!"
//
//
//    Note:
//
//    S.length <= 100
//            33 <= S[i].ASCIIcode <= 122
//    S doesn't contain \ or "

    public String reverse(String S) {
        StringBuilder res = new StringBuilder();
        for (int i = S.length()-1; i >= 0; i--) {
            if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z' || S.charAt(i) >= 'A' && S.charAt(i) <= 'Z') {
                res.append(S.charAt(i));
            }
        }
        return res.toString();
    }

    public List<Boolean> reverseOnlyLetters1(String S) {
        StringBuilder reverseString = new StringBuilder();
        StringBuilder resultString = new StringBuilder();
        List<Boolean> trueOrFalse = new ArrayList<>();
        reverseString.append(reverse(S));

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z' || S.charAt(i) >= 'A' && S.charAt(i) <= 'Z') {
                trueOrFalse.add(false);
            } else
                trueOrFalse.add(true);
        }
        for (int i = 0; i < trueOrFalse.size(); i++) {
            if (trueOrFalse.get(i) == false && trueOrFalse.get(i) != true) {
                resultString.append(reverseString.charAt(i));
            } else
                resultString.append(S.charAt(i));
        }
        return trueOrFalse;
    }

    public void swap(char[] character, int i, int j) {
        char temp = character[i];
        character[i] = character[j];
        character[j] = temp;
    }
    public String reverseOnlyLetters(String S) {
        char[] StoCharArr = S.toCharArray();
        int i = 0, j = StoCharArr.length - 1;
        while (i < j) {
            if (!Character.isLetter(StoCharArr[i])) {
                i++;
            }
            else if (!Character.isLetter(StoCharArr[j])) {
                j--;
            } else {
                swap(StoCharArr, i, j);
                i++;
                j--;
            }
        }
        return new String(StoCharArr);
    }

        public static void main(String[] args) {
        String S = "Test1ng-Leet=code-Q!";
        ReverseOnlyLetters res = new ReverseOnlyLetters();
        System.out.println(res.reverseOnlyLetters(S));
    }
}
