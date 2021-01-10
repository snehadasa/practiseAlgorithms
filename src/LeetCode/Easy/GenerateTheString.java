package LeetCode.Easy;

public class GenerateTheString {
//    Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.
//
//    The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.
//
//
//
//            Example 1:
//
//    Input: n = 4
//    Output: "pppz"
//    Explanation: "pppz" is a valid string since the character 'p' occurs three times and the character 'z' occurs
//    once. Note that there are many other valid strings such as "ohhh" and "love".
//    Example 2:
//
//    Input: n = 2
//    Output: "xy"
//    Explanation: "xy" is a valid string since the characters 'x' and 'y' occur once. Note that there are many other
//    valid strings such as "ag" and "ur".
//    Example 3:
//
//    Input: n = 7
//    Output: "holasss"
//
//
//    Constraints:
//
//            1 <= n <= 500

    public String generateTheString(int n) {
        char ch = 'a';
        int i = 0;
        String res = "", res1 = "";

        while (i < n) {
            if (n <= 26 && ch <= 'z') {
                res += ch;
                ch++;
            } else
            if (n > 26) {
                if (n%2==0 && i <= n) {
                    res += ch;
                }
                ch = 'b';
                if (n%2 == 1) {
                    res += ch;
                }
            }
            i++;
        }


        return res;
    }

    public String generateTheString1(int n) {
        String s="a";
        String ss="b";
        StringBuilder sb=new StringBuilder(n);
        if(n%2 == 0)
        {
            for(int i=0;i<n-1;i++) {
                sb.append(s);
            }
            sb.append(ss);
        } else {
            for(int i=0;i<n;i++) {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 78;
        GenerateTheString res = new GenerateTheString();
        System.out.println(res.generateTheString(n));
    }
}
