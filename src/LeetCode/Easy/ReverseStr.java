package LeetCode.Easy;

public class ReverseStr {
//    Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of
//    the string.
//
//    If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal
//    to k characters, then reverse the first k characters and left the other as original.
//
//
//
//    Example 1:
//
//    Input: s = "abcdefg", k = 2
//    Output: "bacdfeg"
//    Example 2:
//
//    Input: s = "abcd", k = 2
//    Output: "bacd"
//
//
//    Constraints:
//
//            1 <= s.length <= 104
//    s consists of only lowercase English letters.
//1 <= k <= 104

    public void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    public void reverse(char[] ch, int left, int right) {
        while (left < right) {
            swap(ch, left++, right--);
        }
    }
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i+= k*2) {
            reverse(ch, i, Math.min(i+k-1, s.length()-1));
        }

        return new String(ch);
    }


    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        ReverseStr res = new ReverseStr();
        System.out.println(res.reverseStr(s, k));
    }
}
