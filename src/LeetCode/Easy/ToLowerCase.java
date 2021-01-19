package LeetCode.Easy;

public class ToLowerCase {
//    Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
//
//
//
//    Example 1:
//
//    Input: "Hello"
//    Output: "hello"
//    Example 2:
//
//    Input: "here"
//    Output: "here"
//    Example 3:
//
//    Input: "LOVELY"
//    Output: "lovely"

    public String toLowerCase1(String str) {
        String toLower = str.toLowerCase();
        return toLower;
    }

//    public String toLowerCase(String str) {
//
//    }

    public static void main(String[] args) {
        String str = "LOVELY";
        ToLowerCase res = new ToLowerCase();
        System.out.println(res.toLowerCase1(str));

    }
}
