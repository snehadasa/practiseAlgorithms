package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NextGreatestLetter {
//    Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
//    find the smallest element in the list that is larger than the given target.
//
//    Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
//
//    Examples:
//    Input:
//    letters = ["c", "f", "j"]
//    target = "a"
//    Output: "c"
//
//    Input:
//    letters = ["c", "f", "j"]
//    target = "c"
//    Output: "f"
//
//    Input:
//    letters = ["c", "f", "j"]
//    target = "d"
//    Output: "f"
//
//    Input:
//    letters = ["c", "f", "j"]
//    target = "g"
//    Output: "j"
//
//    Input:
//    letters = ["c", "f", "j"]
//    target = "j"
//    Output: "c"
//
//    Input:
//    letters = ["c", "f", "j"]
//    target = "k"
//    Output: "c"
//    Note:
//    letters has a length in range [2, 10000].
//    letters consists of lowercase letters, and contains at least 2 unique letters.
//    target is a lowercase letter.

    public boolean ifTargetIsInArray(char[] letters, char target) {
        for (char letter : letters) {
            if (letter == target) {
                return true;
            }
        }
        return false;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        List<Character> list = new ArrayList<>();
        char res = 0;

        if (target == letters[letters.length - 1]) {
            res = letters[0];
        }

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                list.add(letters[i]);
            }
        }

        if (list.size() > 0) {
            Collections.sort(list);
            res = list.get(0);
        } else {
            res = letters[0];
        }

        return res;
    }

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'g';
        NextGreatestLetter res = new NextGreatestLetter();
        System.out.println(res.nextGreatestLetter(letters, target));
        //System.out.println(res.ifTargetIsInArray(letters, target));
    }
}
