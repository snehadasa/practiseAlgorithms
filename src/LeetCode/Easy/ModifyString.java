package LeetCode.Easy;

public class ModifyString {
//    Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters
//    into lower case letters such that the final string does not contain any consecutive repeating characters. You cannot
//    modify the non '?' characters.
//
//    It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.
//
//    Return the final string after all the conversions (possibly zero) have been made. If there is more than one
//        solution, return any of them. It can be shown that an answer is always possible with the given constraints.
//
//
//
//    Example 1:
//
//    Input: s = "?zs"
//    Output: "azs"
//    Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid
//    modification as the string will consist of consecutive repeating characters in "zzs".
//    Example 2:
//
//    Input: s = "ubv?w"
//    Output: "ubvaw"
//    Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will
//    consist of consecutive repeating characters in "ubvvw" and "ubvww".
//    Example 3:
//
//    Input: s = "j?qg??b"
//    Output: "jaqgacb"
//    Example 4:
//
//    Input: s = "??yw?ipkj?"
//    Output: "acywaipkja"
//
//
//    Constraints:
//
//            1 <= s.length <= 100
//    s contains only lower case English letters and '?'.

    public String modifyString1(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?' && (s.charAt(i-1) == '?')  && s.charAt(i+1) != '?') {
            res = s.replace(s.charAt(i), 'a');
            res = s.replace(s.charAt(i-1), 'b');
            break;
        }
        else if (s.charAt(i) == '?' && (s.charAt(i+1) == '?') && s.charAt(i-1) != '?') {
            res = s.replace(s.charAt(i), 'a');
            res = s.replace(s.charAt(i + 1), 'b');
            break;
        } else
            if (s.charAt(i) == '?' && (s.charAt(i-1) != '?' || s.charAt(i+1) != '?')) {
                if (s.charAt(i-1) != 'a' || s.charAt(i+1) != 'a') {
                    res = s.replace(s.charAt(i), 'a');
                    break;
                }
                else if (s.charAt(i-1) == 'a' || s.charAt(i+1) == 'a' && (s.charAt(i-1) != 'b' || s.charAt(i+1) != 'b')) {
                    res = s.replace(s.charAt(i), 'b');
                    break;
                }
                else if (s.charAt(i-1) == 'a' || s.charAt(i+1) == 'a' || s.charAt(i-1) == 'b' || s.charAt(i+1) == 'b') {
                    res = s.replace(s.charAt(i), 'c');
                    break;
                }
            } else if (s.charAt(i) == '?' && s.charAt(i-1) == '?' && s.charAt(i+1) == '?') {
                res = s.replace(s.charAt(i), 'a');
                res = s.replace(s.charAt(i+1), 'b');
                res = s.replace(s.charAt(i-1), 'c');
                break;
            }
        }
        return res;
    }

    public String modifyString(String s) {
       char[] ch = s.toCharArray();
       char c;

       for (int i = 0; i < ch.length; i++) {
           if (ch[i] == '?') {
               for (c = 'a'; c <= 'z'; c++) {
                   if ((i == 0 || c != ch[i-1]) && (i == ch.length-1 || c != ch[i+1])) {
                       ch[i] = c;
                       break;
                   }
               }
           }
       }
       return String.valueOf(ch);
    }
        public static void main(String[] args) {
        ModifyString res = new ModifyString();
        String s = "j?qg??b";
        System.out.println(res.modifyString(s));
    }
}
