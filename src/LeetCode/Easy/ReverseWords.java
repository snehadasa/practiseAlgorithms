package LeetCode.Easy;

public class ReverseWords {
//    Given a string, you need to reverse the order of characters in each word within a
//    sentence while still preserving whitespace and initial word order.
//
//        Example 1:
//    Input: "Let's take LeetCode contest"
//    Output: "s'teL ekat edoCteeL tsetnoc"
//    Note: In the string, each word is separated by single space and there will not be any extra space in the string.

    public String reverseOneString(String s) {
        char[] newA = s.toCharArray();
        char[] res = new char[newA.length];

        for (int i = newA.length - 1, j = 0; i >= 0; i--) {
            res[j++] = newA[i];
        }
        return String.valueOf(res);
    }

    public String reverseWords(String s) {
        String[] newA = s.split(" ");
        String[] reverse = new String[newA.length];

        for (int i = 0, j = 0; i < newA.length; i++) {
            reverse[j++] = reverseOneString(newA[i]);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reverse.length; i++) {
            result.append(reverse[i]);
            if (i != reverse.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest", s1 = "Love";
        ReverseWords res = new ReverseWords();
        System.out.println(res.reverseWords(s));
       // System.out.println(res.reverseOneString(s1));
    }
}
